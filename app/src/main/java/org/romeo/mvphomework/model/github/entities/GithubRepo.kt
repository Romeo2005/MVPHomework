package org.romeo.mvphomework.model.github.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import org.romeo.mvphomework.model.github.room.entity.RoomRepo
import org.romeo.mvphomework.model.github.room.entity.RoomUser

@Parcelize
data class GithubRepo(
    @Expose val name: String,
    @Expose val language: String?
) : Parcelable {
    companion object {
        fun fromRoomRepo(repo: RoomRepo) =
            GithubRepo(
                name = repo.name,
                language = repo.language
            )
    }
}