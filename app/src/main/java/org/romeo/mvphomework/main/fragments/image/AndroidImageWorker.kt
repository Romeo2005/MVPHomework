package org.romeo.mvphomework.main.fragments.image

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.image.db.IImageDbWorker
import org.romeo.mvphomework.model.image.storage.IImageStorage

class AndroidImageWorker(
    private val dbWorker: IImageDbWorker,
    private val storage: IImageStorage
) : IImageWorker {
    override fun getImageByUrl(url: String): Single<AvatarImage> =
        dbWorker.getImagePathByUrl(url).flatMap { path ->
            storage.get(path).map { bmp ->
                AvatarImage(bmp, url)
            }
        }.subscribeOn(Schedulers.io())


    override fun saveImage(image: AvatarImage): Completable =
        dbWorker.saveImagePathByUrl(image.url)
            .flatMapCompletable { name ->
                storage.save(image.bmp, name)
            }.subscribeOn(Schedulers.io())
}