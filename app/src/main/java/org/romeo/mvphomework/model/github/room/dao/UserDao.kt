package org.romeo.mvphomework.model.github.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.romeo.mvphomework.model.github.room.entity.RoomUser

@Dao
interface UserDao {

    @Query("SELECT * FROM RoomUser")
    fun getAllUsers(): List<RoomUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<RoomUser>)
}