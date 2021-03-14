package org.romeo.mvphomework.main.fragments.fragment_users

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.main.fragments.fragment_users.list.IUserItemView
import org.romeo.mvphomework.main.fragments.fragment_users.list.IUsersListPresenter
import org.romeo.mvphomework.main.fragments.fragment_users.list.UpdateListener
import org.romeo.mvphomework.main.fragments.fragment_users.list.UsersListAdapter
import org.romeo.mvphomework.model.IUsersRepository
import org.romeo.mvphomework.model.entities.User
import org.romeo.mvphomework.navigation.IScreens

class UsersPresenter(
    private val router: Router,
    private val repo: IUsersRepository,
    private val screens: IScreens
) :
    IUsersPresenter, MvpPresenter<IUsersView>() {

    class UsersListPresenter(private val repo: IUsersRepository) :
        IUsersListPresenter {

        override var items: List<User> = run {
            var list: List<User> = listOf()

            repo.getUserObservable.subscribe {
                list = it
            }

            list
        }

        override var updateListener: UpdateListener? = null

        init {
            repo.getUsersSubject().subscribe {
                items = it
                updateListener?.onUpdate?.invoke()
            }
        }

        override val itemsNumber: Int
            get() = items.size

        override fun bind(pos: Int, item: IUserItemView) {
            item.setUsername(items[pos].username)
        }

        override var onClick: ((UsersListAdapter.UserViewHolder) -> Unit)? = null
    }

    override val listPresenter = UsersListPresenter(repo)

    override fun addUserPressed(username: String) {
        repo.addNewUser(User(username))
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.updateList()
        listPresenter.onClick = {
            val user = listPresenter.items[it.adapterPosition]

            val data = mapOf(USER_KEY to user)

            router.navigateTo(screens.getUserScreen(data))
        }
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    companion object {
        private const val TAG = "USERS_PRESENTER_TAG"
    }
}