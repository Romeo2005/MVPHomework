package org.romeo.mvphomework.model.github.storage.repo

import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser
import org.romeo.mvphomework.model.github.network.api.DataSource
import org.romeo.mvphomework.model.github.network.isNetworkAvailable

class RepoStorage(
    private val worker: IRepoDbWorker,
    private val retrofit: DataSource
) : IRepoStorage {
    override fun getUserRepos(user: GithubUser): Single<List<GithubRepo>> =
        isNetworkAvailable().flatMap { isAvailable ->

            if (isAvailable) {
                val reposSingle = retrofit.getGithubRepos(user.reposUrl)

                reposSingle.flatMap { repos ->
                    worker.saveRepos(repos, user.login)
                        .toSingleDefault(repos)
                }



/*                reposSingle.flatMap { repos ->
                    worker.saveRepos(repos, user.login)
                        .subscribeOn(Schedulers.newThread())
                        .toSingle {
                            repos
                        }
                }*/
            } else {
                worker.getReposByUserLogin(user.login)
            }
        }
}