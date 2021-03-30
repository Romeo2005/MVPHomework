package org.romeo.mvphomework.model.github.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.romeo.mvphomework.model.github.room.entity.RoomImage

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(image: RoomImage)

    @Query("SELECT * FROM RoomImage WHERE url = :url LIMIT 1")
    fun getUserImage(url: String): RoomImage?

    @Query("SELECT path FROM RoomImage WHERE url = :url LIMIT 1")
    fun getImagePathByUrl(url: String): String
}