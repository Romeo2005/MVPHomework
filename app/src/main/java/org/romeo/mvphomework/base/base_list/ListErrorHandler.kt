package org.romeo.mvphomework.base.base_list

interface ListErrorHandler<I> {
    fun processError(t: Throwable, item: I)
}