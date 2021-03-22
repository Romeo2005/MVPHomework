package org.romeo.mvphomework.model.image

interface ImageLoader<C> {
    fun load(url: String, container: C)
}