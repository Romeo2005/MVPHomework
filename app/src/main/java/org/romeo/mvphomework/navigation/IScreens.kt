package org.romeo.mvphomework.navigation

import android.os.Bundle
import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.mvphomework.model.entities.User

interface IScreens {
    fun getUsersScreen(): Screen
    fun getUserScreen(bundle: Bundle): Screen
}