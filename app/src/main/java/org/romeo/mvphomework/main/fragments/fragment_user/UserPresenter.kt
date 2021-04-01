package org.romeo.mvphomework.main.fragments.fragment_user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import org.romeo.mvphomework.main.fragments.REPO_KEY
import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.IRepoItemView
import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.IReposListPresenter
import org.romeo.mvphomework.model.github.repository.repo.IReposRepository
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.navigation.screens.IScreens
import javax.inject.Inject

class UserPresenter(
    private val user: GithubUser?,
) : IUserPresenter, MvpPresenter<IUserView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var reposRepo: IReposRepository

    inner class ReposListPresenter : IReposListPresenter {
        override var items: List<GithubRepo> = listOf()

        override val itemsNumber: Int
            get() = items.size

        override fun bind(pos: Int, item: IRepoItemView) {
            item.setName(items[pos].name)
        }

        override var onClick: ((IRepoItemView) -> Unit)? = { item ->
            navigateToRepoFragment(mapOf(REPO_KEY to items[item.num]))
        }
    }

    override val listPresenter = ReposListPresenter()

    override fun navigateToRepoFragment(data: Map<String, GithubRepo>) {
        router.navigateTo(screens.getRepoScreen(data))
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        user?.let {
            viewState.setUsername(user.login)
            viewState.loadAvatar(user.avatarUrl)

            viewState.initReposList()

            reposRepo.getReposSingle(user)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ repos ->
                    listPresenter.items = repos
                    viewState.updateList()
                }, { e ->
                    e.printStackTrace()
                })
        }

    }
}