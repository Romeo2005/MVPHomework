package org.romeo.mvphomework.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.navigation.App
import javax.inject.Singleton

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun app() = app
}