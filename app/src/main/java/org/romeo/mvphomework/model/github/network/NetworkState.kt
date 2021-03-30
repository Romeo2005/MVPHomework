package org.romeo.mvphomework.model.github.network

import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import okhttp3.Request

fun isNetworkAvailable(): Single<Boolean> = Single.fromCallable {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url(NETWORK_TEST)
        .build()

    try {
        val response = client.newCall(request).execute()
        response.isSuccessful
    } catch(e: Throwable) {
        false
    }
}