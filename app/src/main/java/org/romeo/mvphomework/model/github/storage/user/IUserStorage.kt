package org.romeo.mvphomework.model.github.storage.user

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubUser

interface IUserStorage {
    fun getUsers(): Single<List<GithubUser>>
}