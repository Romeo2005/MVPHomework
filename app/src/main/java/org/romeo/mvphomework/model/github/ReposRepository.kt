package org.romeo.mvphomework.model.github

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.github.api.DataSource
import org.romeo.mvphomework.model.github.entities.GithubRepo

class ReposRepository(private val dataSource: DataSource) : IReposRepository{
    override fun getReposSingle(url: String): Single<List<GithubRepo>> =
        dataSource.getGithubRepos(url).subscribeOn(Schedulers.io())
}