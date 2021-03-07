package org.romeo.mvphomework.main.fragments.fragment_users

import android.os.Bundle
import android.util.Log
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.main.fragments.fragment_user.UserPresenter
import org.romeo.mvphomework.main.fragments.fragment_users.list.IUsersListPresenter
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

    class UsersListPresenter(repo: IUsersRepository) :
        IUsersListPresenter {

        override var items = repo.users

        override val itemsNumber: Int
            get() = items.size

        override fun bind(pos: Int, item: UsersListAdapter.UserViewHolder) {
            item.setUsername(items[pos].username)
        }

        override var onClick: ((UsersListAdapter.UserViewHolder) -> Unit)? = null


/*        private fun startUserFragment(user: User) {
            Log.d(TAG, "startUserFragment: ${user.username}")
        }*/
    }

    override val listPresenter = UsersListPresenter(repo)

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.updateList()
        listPresenter.onClick = {
            val user = listPresenter.items[it.adapterPosition]

            val data = Bundle()

            data.putParcelable(USER_KEY, user)

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