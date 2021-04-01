package org.romeo.mvphomework.main.fragments.image

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import org.romeo.mvphomework.model.image.storage.IImageStorage
import java.io.File
import java.io.FileInputStream


class AndroidImageStorage(
    private val context: Context
    ) : IImageStorage {
    override fun save(bmp: Bitmap, filename: String): Completable =
        Completable.fromAction {
            val out = context.openFileOutput(filename, Context.MODE_PRIVATE)

            bmp.compress(Bitmap.CompressFormat.PNG, 100, out)

            out.close()
        }

    override fun get(filename: String): Single<Bitmap> =
        Single.fromCallable {
            val file = File(filename)
            BitmapFactory.decodeStream(FileInputStream(file))
        }
}