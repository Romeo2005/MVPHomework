package org.romeo.mvphomework.main.fragments.image

import android.graphics.Bitmap
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import io.reactivex.rxjava3.schedulers.Schedulers
import org.romeo.mvphomework.model.image.ImageLoader

class GlideImageLoader(
    private val worker: IImageWorker
) : ImageLoader<ImageView> {

    override fun load(url: String, container: ImageView) {
        Glide.with(container.context)
            .asBitmap()
            .load(url)
            .listener(object : RequestListener<Bitmap> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    isFirstResource: Boolean
                ): Boolean {
                    worker.getImageByUrl(url).subscribe({ avatar ->
                        container.setImageBitmap(avatar.bmp)
                    }, {
                        throw RuntimeException(ERROR)
                    })

                    return true
                }

                override fun onResourceReady(
                    resource: Bitmap?,
                    model: Any?,
                    target: Target<Bitmap>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    resource?.let {
                        worker.saveImage(AvatarImage(resource, url))
                            .observeOn(Schedulers.io())
                            .subscribe({
                                Log.d(TAG, "onResourceReady: successfully saved")
                            }, {
                                throw it
                            })
                    }

                    return false
                }

            })
            .circleCrop()
            .into(container)
    }

    companion object {
        const val TAG = "IMAGE_LOADER_TAG"
        const val ERROR = "There is no image in db associated with this url"
    }
}