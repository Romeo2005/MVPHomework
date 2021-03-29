package org.romeo.mvphomework.model.github.repository

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.github.network.api.DataSource
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.model.github.storage.repo.IRepoStorage

class ReposRepository(
    private val storage: IRepoStorage
) : IReposRepository {
    override fun getReposSingle(user: GithubUser): Single<List<GithubRepo>> =
        storage.getUserRepos(user).subscribeOn(Schedulers.io())
}