package org.romeo.mvphomework.navigation

import android.app.Application
import org.romeo.mvphomework.dagger.component.DaggerMainComponent
import org.romeo.mvphomework.dagger.component.MainComponent
import org.romeo.mvphomework.dagger.module.AppModule
import org.romeo.mvphomework.model.github.room.db.GithubDb

class App : Application() {
    lateinit var mainComponent: MainComponent

    companion object {
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        GithubDb.create(this)

        mainComponent =
            DaggerMainComponent
                .builder()
                .appModule(AppModule(this))
                .build()

        instance = this
    }
}