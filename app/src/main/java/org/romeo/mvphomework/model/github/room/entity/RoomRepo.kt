package org.romeo.mvphomework.model.github.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import org.romeo.mvphomework.model.github.entities.GithubRepo

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = RoomUser::class,
            parentColumns = ["login"],
            childColumns = ["userLogin"],
            onDelete = ForeignKey.NO_ACTION
        )
    ]
)
data class RoomRepo(
    @PrimaryKey
    val id: String,
    val name: String,
    val language: String?,
    val userLogin: String
) {
    companion object {
        fun fromGithubRepo(
            repo: GithubRepo,
            userLogin: String,
            id: String
        ) =
            RoomRepo(
                id = id,
                name = repo.name,
                language = repo.language,
                userLogin = userLogin
            )
    }
}