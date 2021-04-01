package org.romeo.mvphomework.navigation.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.main.fragments.fragment_repository.RepoFragment
import org.romeo.mvphomework.main.fragments.fragment_user.UserFragment
import org.romeo.mvphomework.main.fragments.fragment_users.UsersFragment
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.model.github.entities.GithubUser

class Screens : IScreens {
    override fun getUsersScreen() =
        FragmentScreen { BaseFragment.newInstance<UsersFragment>() }

    override fun getUserScreen(args: Map<String, GithubUser>) =
        FragmentScreen { BaseFragment.newInstance<UserFragment>(args) }

    override fun getRepoScreen(args: Map<String, GithubRepo>) =
        FragmentScreen { BaseFragment.newInstance<RepoFragment>(args) }
}