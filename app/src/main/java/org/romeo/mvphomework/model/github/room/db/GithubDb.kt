package org.romeo.mvphomework.model.github.room.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.romeo.mvphomework.model.github.room.dao.RepoDao
import org.romeo.mvphomework.model.github.room.dao.UserDao
import org.romeo.mvphomework.model.github.room.entity.RoomRepo
import org.romeo.mvphomework.model.github.room.entity.RoomUser

@Database(
    entities = [
        RoomUser::class,
        RoomRepo::class
    ],
    version = 1
)
abstract class GithubDb : RoomDatabase(){
    abstract val userDao: UserDao
    abstract val repoDao: RepoDao

    companion object {
        lateinit var instance: GithubDb

        private const val DB_NAME = "GithubDb"

        fun create(context: Context) {
            instance = Room.databaseBuilder(
                context,
                GithubDb::class.java,
                DB_NAME
            ).build()
        }
    }
}