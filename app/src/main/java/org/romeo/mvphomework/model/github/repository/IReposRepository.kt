package org.romeo.mvphomework.model.github.repository

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser

interface IReposRepository {
    fun getReposSingle(user: GithubUser): Single<List<GithubRepo>>
}