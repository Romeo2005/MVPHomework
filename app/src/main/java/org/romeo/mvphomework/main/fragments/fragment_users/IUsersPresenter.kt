package org.romeo.mvphomework.main.fragments.fragment_users

import org.romeo.mvphomework.main.fragments.fragment_users.list.UpdateListener
import org.romeo.mvphomework.navigation.BackPressedListener

interface IUsersPresenter : BackPressedListener {
    val listPresenter: UsersPresenter.UsersListPresenter
    fun addUserPressed(username: String)
}