package org.romeo.mvphomework.model.github.entities

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubRepo(
    @Expose val name: String,
    @Expose val language: String?
) : Parcelable