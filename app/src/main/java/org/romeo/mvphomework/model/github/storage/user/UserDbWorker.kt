package org.romeo.mvphomework.model.github.storage.user

import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.model.github.room.dao.UserDao
import org.romeo.mvphomework.model.github.room.entity.RoomUser

class UserDbWorker(
    private val dao: UserDao
) : IUserDbWorker {
    override fun saveUsers(users: List<GithubUser>) {
        dao.insert(users.map {
            RoomUser.fromGithubUser(it)
        })
    }

    override fun getUsers(): List<GithubUser> =
        dao.getAllUsers().map { GithubUser.fromRoomUser(it) }
}