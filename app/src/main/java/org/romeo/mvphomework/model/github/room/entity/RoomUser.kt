package org.romeo.mvphomework.model.github.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.romeo.mvphomework.model.github.entities.GithubUser

@Entity
data class RoomUser(
    @PrimaryKey
    val login: String,
    val reposUrl: String,
    val avatarUrl: String
) {
    companion object {
        fun fromGithubUser(user: GithubUser) =
            RoomUser(
                login = user.login,
                avatarUrl = user.avatarUrl,
                reposUrl = user.reposUrl
            )
    }
}