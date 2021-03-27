package org.romeo.mvphomework.navigation

import com.github.terrakok.cicerone.Screen
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser

interface IScreens {
    fun getUsersScreen(): Screen
    fun getUserScreen(args: Map<String, GithubUser>): Screen
    fun getRepoScreen(args: Map<String, GithubRepo>): Screen
}