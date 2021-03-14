package org.romeo.mvphomework.model.entities

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var username: String) : Parcelable