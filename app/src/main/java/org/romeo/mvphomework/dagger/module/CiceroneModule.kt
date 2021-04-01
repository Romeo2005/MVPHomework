package org.romeo.mvphomework.dagger.module

import com.github.terrakok.cicerone.Cicerone
import dagger.Module
import dagger.Provides

@Module
class CiceroneModule {
    private val cicerone = Cicerone.create()

    @Provides
    fun navigatorHolder() = cicerone.getNavigatorHolder()

    @Provides
    fun router() = cicerone.router
}