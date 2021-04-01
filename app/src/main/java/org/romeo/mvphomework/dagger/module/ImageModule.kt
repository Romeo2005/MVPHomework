package org.romeo.mvphomework.dagger.module

import android.widget.ImageView
import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.main.fragments.image.AndroidImageWorker
import org.romeo.mvphomework.main.fragments.image.GlideImageLoader
import org.romeo.mvphomework.main.fragments.image.IImageWorker
import org.romeo.mvphomework.model.image.ImageLoader
import org.romeo.mvphomework.model.image.db.IImageDbWorker
import org.romeo.mvphomework.model.image.storage.IImageStorage
import javax.inject.Singleton

@Module
class ImageModule {
    @Provides
    @Singleton
    fun imageWorker(
        worker: IImageDbWorker,
        storage: IImageStorage
    ): IImageWorker = AndroidImageWorker(worker, storage)

    @Provides
    @Singleton
    fun imageLoader(worker: IImageWorker): ImageLoader<ImageView> =
        GlideImageLoader(worker)
}