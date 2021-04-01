package org.romeo.mvphomework.dagger.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import org.romeo.mvphomework.model.github.network.api.DataSource
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    @Named("MainGson")
    fun gson() =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .excludeFieldsWithoutExposeAnnotation()
            .create()


    @Provides
    @Singleton
    fun dataSource(
        @Named("BaseUrl") url: String,
        @Named("MainGson") gson: Gson
    ): DataSource =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
            .create(DataSource::class.java)

    @Provides
    @Named("BaseUrl")
    @Singleton
    fun baseUrl(): String = GITHUB_BASE

    @Provides
    @Named("TestUrl")
    @Singleton
    fun testUrl(): String = NETWORK_TEST
}

const val GITHUB_BASE = "https://api.github.com/"
const val NETWORK_TEST = "https://google.com/"