package org.romeo.mvphomework.main.fragments.image

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IImageWorker {
    fun getImageByUrl(url: String): Single<AvatarImage>

    fun saveImage(image: AvatarImage): Completable
}