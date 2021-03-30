package org.romeo.mvphomework.model.image.storage

import android.graphics.Bitmap
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface IImageStorage {
    fun save(bmp: Bitmap, filename: String): Completable

    fun get(filename: String): Single<Bitmap>
}