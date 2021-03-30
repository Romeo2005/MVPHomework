package org.romeo.mvphomework.main.activity

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.R
import org.romeo.mvphomework.databinding.ActivityMainBinding
import org.romeo.mvphomework.navigation.App
import org.romeo.mvphomework.base.base_view.BackPressedListener
import org.romeo.mvphomework.navigation.screens.Screens

class MainActivity : MvpAppCompatActivity(), MainView {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navigator by lazy {
        AppNavigator(this, R.id.main_container)
    }

    private val presenter by moxyPresenter {
        MainPresenter(Screens, App.instance.router)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.instance.navigatorHolder.removeNavigator()

        super.onPause()
    }

    override fun onBackPressed() {
        val backListeners =
            supportFragmentManager.fragments
                .filter { it is BackPressedListener }
                .map { it as BackPressedListener }

        var res = false

        if (backListeners.isNotEmpty())
            backListeners.forEach { res = res || it.onBackPressed() }

        if (!res) presenter.onBackPressed()
    }
}