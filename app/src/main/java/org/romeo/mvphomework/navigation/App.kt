package org.romeo.mvphomework.navigation

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import org.romeo.mvphomework.model.github.room.db.GithubDb

class App : Application() {
    private val cicerone by lazy { Cicerone.create() }

    val navigatorHolder get() = cicerone.getNavigatorHolder()

    val router get() = cicerone.router

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        GithubDb.create(this)
        instance = this
    }
}