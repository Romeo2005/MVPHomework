package org.romeo.mvphomework.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.navigation.screens.IScreens
import org.romeo.mvphomework.navigation.screens.Screens
import javax.inject.Singleton

@Module
class ScreensModule {

    @Singleton
    @Provides
    fun screens(): IScreens = Screens()
}