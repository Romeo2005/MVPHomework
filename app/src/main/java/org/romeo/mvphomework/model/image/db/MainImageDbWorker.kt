package org.romeo.mvphomework.model.image.db

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.github.room.dao.ImageDao
import org.romeo.mvphomework.model.github.room.entity.RoomImage
import java.util.*

class MainImageDbWorker(
    private val dao: ImageDao
) : IImageDbWorker {
    override fun getImagePathByUrl(url: String): Single<String> =
        Single.just(dao.getImagePathByUrl(url))

    override fun saveImagePathByUrl(url: String): Single<String> =
        Single.fromCallable {
            val path = dao.getUserImage(url)?.path ?: UUID.randomUUID().toString()

            dao.insert(RoomImage(path, url))

            return@fromCallable path
        }

}