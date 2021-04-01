package org.romeo.mvphomework.model.github.storage.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubRepo

interface IRepoDbWorker {
    fun saveRepos(repos: List<GithubRepo>, userLogin: String): Completable
    fun getReposByUserLogin(userLogin: String): Single<List<GithubRepo>>
}