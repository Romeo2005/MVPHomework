package org.romeo.mvphomework.model.github.api

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser
import retrofit2.http.GET
import retrofit2.http.Url

interface DataSource {
    @GET("users")
    fun getGithubUsers(): Single<List<GithubUser>>

    @GET
    fun getGithubRepos(@Url url: String): Single<List<GithubRepo>>
}