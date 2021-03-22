package org.romeo.mvphomework.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.main.fragments.fragment_user.UserFragment
import org.romeo.mvphomework.main.fragments.fragment_users.UsersFragment
import org.romeo.mvphomework.model.github.entities.GithubUser

object Screens : IScreens {
    override fun getUsersScreen() =
        FragmentScreen { BaseFragment.newInstance<UsersFragment>() }

    override fun getUserScreen(args: Map<String, GithubUser>) =
        FragmentScreen { BaseFragment.newInstance<UserFragment>(args) }
}