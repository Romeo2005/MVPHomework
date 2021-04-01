package org.romeo.mvphomework.main.fragments.fragment_users

import org.romeo.mvphomework.base.base_view.BackPressedListener

interface IUsersPresenter : BackPressedListener {
    val listPresenter: UsersPresenter.UsersListPresenter
}