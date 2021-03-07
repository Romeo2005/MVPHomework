package org.romeo.mvphomework.main.fragments.fragment_user

import android.os.Bundle
import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.model.entities.User
import org.romeo.mvphomework.navigation.IScreens

class UserPresenter(
    arguments: Bundle?,
    private val router: Router,
    private val screens: IScreens
) : IUserPresenter, MvpPresenter<IUserView>() {

    val user = arguments?.getParcelable<User>(USER_KEY)

    override fun onBackPressed(): Boolean {
        router.replaceScreen(screens.getUsersScreen())
        return true
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        user?.username?.let { viewState.setUsernameText(it) }
    }
}