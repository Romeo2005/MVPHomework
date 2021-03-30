package org.romeo.mvphomework.model.image.db

import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.main.fragments.image.AvatarImage

interface IImageDbWorker {
    fun getImagePathByUrl(url: String): Single<String>

    fun saveImagePathByUrl(url: String): Single<String>
}