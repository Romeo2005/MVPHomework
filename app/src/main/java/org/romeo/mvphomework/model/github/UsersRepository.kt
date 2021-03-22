package org.romeo.mvphomework.model.github

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.github.api.DataSource
import org.romeo.mvphomework.model.github.entities.GithubUser

class UsersRepository(private val dataSource: DataSource) : IUsersRepository {
    override fun getUsersSingle(): Single<List<GithubUser>> =
        dataSource.getGithubUsers().subscribeOn(Schedulers.io())
}