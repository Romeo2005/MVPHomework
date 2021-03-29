package org.romeo.mvphomework.model.github.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import org.romeo.mvphomework.model.github.room.entity.RoomRepo

@Dao
interface RepoDao {

    @Insert(onConflict = REPLACE)
    fun insert(repos: List<RoomRepo>)

    @Query("SELECT * FROM RoomRepo WHERE userLogin = :userLogin")
    fun getAllUserRepos(userLogin: String): List<RoomRepo>

    @Query("SELECT * FROM RoomRepo WHERE userLogin = :userLogin & name = :name LIMIT 1")
    fun getUserReposByName(userLogin: String, name: String): RoomRepo?
}