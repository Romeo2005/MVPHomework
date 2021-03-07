package org.romeo.mvphomework.model

import org.romeo.mvphomework.model.entities.User

interface IUsersRepository {
    val users: List<User>
}