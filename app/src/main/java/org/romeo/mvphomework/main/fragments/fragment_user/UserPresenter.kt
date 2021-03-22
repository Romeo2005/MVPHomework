package org.romeo.mvphomework.main.fragments.fragment_user

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.IRepoItemView
import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.IReposListPresenter
import org.romeo.mvphomework.model.github.IReposRepository
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.navigation.IScreens

class UserPresenter(
    private val user: GithubUser?,
    private val reposRepo: IReposRepository,
    private val router: Router,
    private val screens: IScreens
) : IUserPresenter, MvpPresenter<IUserView>() {

    class ReposListPresenter : IReposListPresenter {
        override var items: List<GithubRepo> = listOf()

        override val itemsNumber: Int
            get() = items.size

        override fun bind(pos: Int, item: IRepoItemView) {
            item.setName(items[pos].name)
        }
    }

    override val listPresenter = ReposListPresenter()

    override fun onBackPressed(): Boolean {
        router.replaceScreen(screens.getUsersScreen())
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()



        user?.let {
            viewState.setUsername(user.login)
            viewState.loadAvatar(user.avatarUrl)

            viewState.initReposList()

            reposRepo.getReposSingle(user.reposUrl)
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