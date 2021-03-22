package org.romeo.mvphomework.model.github

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubRepo

interface IReposRepository {
    fun getReposSingle(url: String): Single<List<GithubRepo>>
}