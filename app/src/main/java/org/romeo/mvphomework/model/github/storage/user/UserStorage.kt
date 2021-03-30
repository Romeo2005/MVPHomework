package org.romeo.mvphomework.model.github.storage.user

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.model.github.network.api.DataSource

class UserStorage(
    private val worker: IUserDbWorker,
    private val retrofit: DataSource
) : IUserStorage {
    override fun getUsers(): Single<List<GithubUser>> =
        //Работает быстрее
        Single.create { emitter ->
            retrofit.getGithubUsers().blockingSubscribe({ users ->
                worker.saveUsers(users)
                emitter.onSuccess(users)
            }, {
                emitter.onSuccess(worker.getUsers())
            })
        }
}