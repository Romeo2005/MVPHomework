package org.romeo.mvphomework.model.github.storage.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser

interface IRepoStorage {
    fun getUserRepos(user: GithubUser): Single<List<GithubRepo>>
}