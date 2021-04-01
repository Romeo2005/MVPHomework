package org.romeo.mvphomework.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.model.github.repository.repo.IReposRepository
import org.romeo.mvphomework.model.github.repository.repo.ReposRepository
import org.romeo.mvphomework.model.github.repository.user.IUsersRepository
import org.romeo.mvphomework.model.github.repository.user.UsersRepository
import org.romeo.mvphomework.model.github.storage.repo.IRepoStorage
import org.romeo.mvphomework.model.github.storage.user.IUserStorage
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun usersRepository(storage: IUserStorage): IUsersRepository =
        UsersRepository(storage)

    @Provides
    @Singleton
    fun reposRepository(storage: IRepoStorage): IReposRepository =
        ReposRepository(storage)
}