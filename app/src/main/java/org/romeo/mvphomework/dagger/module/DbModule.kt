package org.romeo.mvphomework.dagger.module

import androidx.room.Room
import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.model.github.room.dao.ImageDao
import org.romeo.mvphomework.model.github.room.dao.RepoDao
import org.romeo.mvphomework.model.github.room.dao.UserDao
import org.romeo.mvphomework.model.github.room.db.GithubDb
import org.romeo.mvphomework.model.github.storage.repo.IRepoDbWorker
import org.romeo.mvphomework.model.github.storage.repo.RepoDbWorker
import org.romeo.mvphomework.model.github.storage.user.IUserDbWorker
import org.romeo.mvphomework.model.github.storage.user.UserDbWorker
import org.romeo.mvphomework.model.image.db.IImageDbWorker
import org.romeo.mvphomework.model.image.db.MainImageDbWorker
import org.romeo.mvphomework.navigation.App
import javax.inject.Named
import javax.inject.Singleton

@Module
class DbModule {
    @Singleton
    @Provides
    fun githubDb(
        @Named("DB_NAME") name: String,
        app: App
    ) =
        Room.databaseBuilder(
            app,
            GithubDb::class.java,
            name
        ).build()

    @Provides
    fun repoDao(db: GithubDb) = db.repoDao


    @Provides
    fun userDao(db: GithubDb) = db.userDao

    @Provides
    fun imageDao(db: GithubDb) = db.imageDao

    @Singleton
    @Provides
    fun repoDbWorker(dao: RepoDao): IRepoDbWorker =
        RepoDbWorker(dao)

    @Singleton
    @Provides
    fun userDbWorker(dao: UserDao): IUserDbWorker =
        UserDbWorker(dao)

    @Singleton
    @Provides
    fun imageDbWorker(dao: ImageDao): IImageDbWorker =
        MainImageDbWorker(dao)

    @Singleton
    @Provides
    @Named("DB_NAME")
    fun dbName() = DB_NAME
}

private const val DB_NAME = "GithubDb"
