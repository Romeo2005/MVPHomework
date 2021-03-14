package org.romeo.mvphomework.navigation

import com.github.terrakok.cicerone.Screen
import org.romeo.mvphomework.model.entities.User

interface IScreens {
    fun getUsersScreen(): Screen
    fun getUserScreen(args: Map<String, User>): Screen
}