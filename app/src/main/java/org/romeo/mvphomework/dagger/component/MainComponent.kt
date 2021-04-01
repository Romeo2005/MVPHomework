package org.romeo.mvphomework.dagger.component

import dagger.Component
import org.romeo.mvphomework.dagger.module.*
import org.romeo.mvphomework.main.activity.MainActivity
import org.romeo.mvphomework.main.activity.MainPresenter
import org.romeo.mvphomework.main.fragments.fragment_repository.RepoPresenter
import org.romeo.mvphomework.main.fragments.fragment_user.UserFragment
import org.romeo.mvphomework.main.fragments.fragment_user.UserPresenter
import org.romeo.mvphomework.main.fragments.fragment_users.UsersFragment
import org.romeo.mvphomework.main.fragments.fragment_users.UsersPresenter
import org.romeo.mvphomework.main.fragments.fragment_users.users_list.UsersListAdapter
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        CiceroneModule::class,
        ScreensModule::class,
        ApiModule::class,
        AppModule::class,
        DbModule::class,
        ImageModule::class,
        RepositoryModule::class,
        StorageModule::class,
        SchedulersModule::class
    ]
)
interface MainComponent {
    fun inject(presenter: UserPresenter)
    fun inject(presenter: UsersPresenter)
    fun inject(presenter: RepoPresenter)
    fun inject(presenter: MainPresenter)

    fun inject(fragment: UserFragment)
    fun inject(activity: MainActivity)
    fun inject(adapter: UsersListAdapter)
}