package org.romeo.mvphomework.model.github.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.romeo.mvphomework.main.fragments.image.AvatarImage

@Entity
data class RoomImage(
    @PrimaryKey
    val path: String,
    val url: String,
)