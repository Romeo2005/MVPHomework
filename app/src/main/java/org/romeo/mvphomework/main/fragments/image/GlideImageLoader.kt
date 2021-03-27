package org.romeo.mvphomework.main.fragments.image

import android.widget.ImageView
import com.bumptech.glide.Glide
import org.romeo.mvphomework.model.image.ImageLoader

class GlideImageLoader : ImageLoader<ImageView> {

    override fun load(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .circleCrop()
            .into(container)
    }
}