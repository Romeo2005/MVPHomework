package org.romeo.mvphomework.model.github.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize
import org.romeo.mvphomework.model.github.room.entity.RoomUser

@Parcelize
data class GithubUser(
    @Expose val login: String,
    @Expose val avatarUrl: String,
    @Expose val reposUrl: String
) : Parcelable {

    companion object {
        fun fromRoomUser(user: RoomUser) =
            GithubUser(
                login = user.login,
                avatarUrl = user.avatarUrl,
                reposUrl = user.reposUrl
            )
    }
}