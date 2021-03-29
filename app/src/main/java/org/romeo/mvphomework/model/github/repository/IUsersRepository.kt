package org.romeo.mvphomework.model.github.repository

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubUser

interface IUsersRepository {
    fun getUsersSingle(): Single<List<GithubUser>>
}