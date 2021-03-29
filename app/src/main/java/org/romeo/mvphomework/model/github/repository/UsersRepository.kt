package org.romeo.mvphomework.model.github.repository

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.github.network.api.DataSource
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.model.github.storage.user.UserStorage

class UsersRepository(private val storage: UserStorage) : IUsersRepository {
    override fun getUsersSingle(): Single<List<GithubUser>> =
        storage.getUsers().subscribeOn(Schedulers.io())
}