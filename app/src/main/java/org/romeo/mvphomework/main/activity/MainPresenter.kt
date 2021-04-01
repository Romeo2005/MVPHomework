package org.romeo.mvphomework.main.activity

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import org.romeo.mvphomework.base.base_view.BackPressedListener
import org.romeo.mvphomework.navigation.screens.IScreens
import javax.inject.Inject

class MainPresenter : MvpPresenter<MainView>(), BackPressedListener {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        router.replaceScreen(screens.getUsersScreen())

        super.onFirstViewAttach()
    }

    override fun onBackPressed(): Boolean {
        router.exit()
        return true
    }
}