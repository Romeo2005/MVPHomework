package org.romeo.mvphomework.model.github.storage.user

import org.romeo.mvphomework.model.github.entities.GithubUser

interface IUserDbWorker {
    fun saveUsers(users: List<GithubUser>)
    fun getUsers(): List<GithubUser>
}