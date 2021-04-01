package org.romeo.mvphomework.main.fragments.fragment_repository

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.mvphomework.model.github.entities.GithubRepo
import javax.inject.Inject

class RepoPresenter(
    private val repo: GithubRepo?,
) : MvpPresenter<RepoView>(), IRepoPresenter {

    @Inject
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        repo?.let { repo ->
            repo.language?.let { language ->
                viewState.showRepoLanguage(language)
            }
        }
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}