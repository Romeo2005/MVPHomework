package org.romeo.mvphomework.main.fragments.fragment_user

import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.IReposListPresenter
import org.romeo.mvphomework.navigation.BackPressedListener

interface IUserPresenter : BackPressedListener {
    val listPresenter: IReposListPresenter
}