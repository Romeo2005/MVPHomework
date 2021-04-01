package org.romeo.mvphomework.dagger.module

import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.main.fragments.image.AndroidImageStorage
import org.romeo.mvphomework.model.github.network.api.DataSource
import org.romeo.mvphomework.model.github.storage.repo.IRepoDbWorker
import org.romeo.mvphomework.model.github.storage.repo.IRepoStorage
import org.romeo.mvphomework.model.github.storage.repo.RepoStorage
import org.romeo.mvphomework.model.github.storage.user.IUserDbWorker
import org.romeo.mvphomework.model.github.storage.user.IUserStorage
import org.romeo.mvphomework.model.github.storage.user.UserStorage
import org.romeo.mvphomework.model.image.db.IImageDbWorker
import org.romeo.mvphomework.model.image.storage.IImageStorage
import org.romeo.mvphomework.navigation.App
import javax.inject.Singleton

@Module
class StorageModule {
    @Provides
    @Singleton
    fun repoStorage(
        dataSource: DataSource,
        worker: IRepoDbWorker
    ): IRepoStorage =
        RepoStorage(
            retrofit = dataSource,
            worker = worker
        )

    @Provides
    @Singleton
    fun userStorage(
        dataSource: DataSource,
        worker: IUserDbWorker
    ): IUserStorage =
        UserStorage(
            retrofit = dataSource,
            worker = worker
        )

    @Provides
    @Singleton
    fun imageStorage(app: App): IImageStorage =
        AndroidImageStorage(app)
}