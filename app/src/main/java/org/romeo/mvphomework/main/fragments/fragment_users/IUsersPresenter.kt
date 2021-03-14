package org.romeo.mvphomework.main.fragments.fragment_users

import org.romeo.mvphomework.navigation.BackPressedListener

interface IUsersPresenter : BackPressedListener {
    val listPresenter: UsersPresenter.UsersListPresenter
}