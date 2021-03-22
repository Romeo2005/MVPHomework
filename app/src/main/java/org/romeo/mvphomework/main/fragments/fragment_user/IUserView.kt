package org.romeo.mvphomework.main.fragments.fragment_user

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserView : MvpView {
    fun initReposList()

    fun updateList()

    fun setUsername(username: String)

    fun loadAvatar(url: String)
}