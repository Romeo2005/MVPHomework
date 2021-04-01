package org.romeo.mvphomework.dagger.module

import dagger.Module
import dagger.Provides
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Scheduler
import javax.inject.Named

@Module
class SchedulersModule {
    @Provides
    @Named("MAIN")
    fun mainScheduler(): Scheduler = AndroidSchedulers.mainThread()
}