package org.romeo.mvphomework.model.github.storage.repo

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.room.dao.RepoDao
import org.romeo.mvphomework.model.github.room.entity.RoomRepo
import java.util.*

class RepoDbWorker(
    private val dao: RepoDao
) : IRepoDbWorker {
    override fun saveRepos(repos: List<GithubRepo>, userLogin: String): Completable =
        Completable.fromAction {
            val roomRepos = repos.map { repoOld ->
                val repoDb = dao.getUserReposByName(
                    userLogin,
                    repoOld.name
                )

                val id = repoDb?.id ?: UUID.randomUUID().toString()

                RoomRepo.fromGithubRepo(repoOld, userLogin, id)
            }

            dao.insert(roomRepos)
        }

    override fun getReposByUserLogin(userLogin: String): Single<List<GithubRepo>> =
        Single.fromCallable {
            dao.getAllUserRepos(userLogin)
                .map { GithubRepo.fromRoomRepo(it) }
        }
}