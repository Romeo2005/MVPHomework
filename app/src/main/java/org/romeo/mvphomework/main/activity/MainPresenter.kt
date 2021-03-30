package org.romeo.mvphomework.main.activity

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.mvphomework.base.base_view.BackPressedListener
import org.romeo.mvphomework.navigation.screens.IScreens

class MainPresenter(
    private val screens: IScreens,
    private val router: Router
) : MvpPresenter<MainView>(), BackPressedListener {

    override fun onFirstViewAttach() {
        router.replaceScreen(screens.getUsersScreen())

        super.onFirstViewAttach()
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}