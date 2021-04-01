package org.romeo.mvphomework.main.fragments.fragment_users

import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import moxy.MvpPresenter
import org.romeo.mvphomework.base.DEFAULT_ERROR_MESSAGE
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.main.fragments.fragment_users.users_list.IUserItemView
import org.romeo.mvphomework.main.fragments.fragment_users.users_list.IUsersListPresenter
import org.romeo.mvphomework.model.github.repository.user.IUsersRepository
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.navigation.screens.IScreens
import javax.inject.Inject

class UsersPresenter :
    IUsersPresenter, MvpPresenter<IUsersView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    @Inject
    lateinit var repo: IUsersRepository


    class UsersListPresenter : IUsersListPresenter {

        override var items: List<GithubUser> = listOf()

        override val itemsNumber: Int
            get() = items.size

        override fun bind(pos: Int, item: IUserItemView) {
            item.setUsername(items[pos].login)
            item.setAvatar(items[pos].avatarUrl)
        }

        override var onClick: ((IUserItemView) -> Unit)? = null

        override fun processError(t: Throwable, item: IUserItemView) {
            item.showMessage(t.message ?: DEFAULT_ERROR_MESSAGE)
        }
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