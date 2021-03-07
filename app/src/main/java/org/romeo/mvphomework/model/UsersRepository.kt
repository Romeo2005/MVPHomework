package org.romeo.mvphomework.model

import org.romeo.mvphomework.model.entities.User

object UsersRepository : IUsersRepository {
    override val users = listOf(
        User("User1"),
        User("User2"),
        User("User3"),
    )
}