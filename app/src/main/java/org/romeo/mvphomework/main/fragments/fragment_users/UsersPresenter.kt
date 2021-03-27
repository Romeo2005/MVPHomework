package org.romeo.mvphomework.main.fragments.fragment_users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.main.fragments.fragment_users.users_list.IUserItemView
import org.romeo.mvphomework.main.fragments.fragment_users.users_list.IUsersListPresenter
import org.romeo.mvphomework.model.github.IUsersRepository
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.navigation.IScreens

class UsersPresenter(
    private val router: Router,
    private val repo: IUsersRepository,
    private val screens: IScreens
) :
    IUsersPresenter, MvpPresenter<IUsersView>() {

    class UsersListPresenter : IUsersListPresenter {

        override var items: List<GithubUser> = listOf()

        override val itemsNumber: Int
            get() = items.size

        override fun bind(pos: Int, item: IUserItemView) {
            item.setUsername(items[pos].login)
            item.setAvatar(items[pos].avatarUrl)
        }

        override var onClick: ((IUserItemView) -> Unit)? = null
    }

    override val listPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        initListAdapter()
        listPresenter.onClick = {
            val user = listPresenter.items[it.num]

            val data = mapOf(USER_KEY to user)

            router.navigateTo(screens.getUserScreen(data))
        }
    }

    private fun initListAdapter() {
        repo.getUsersSingle()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ users ->
                listPresenter.items = users
                viewState.updateList()
            }, { e ->
                e.printStackTrace()
            })
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    companion object {
        private const val TAG = "USERS_PRESENTER_TAG"
    }
}