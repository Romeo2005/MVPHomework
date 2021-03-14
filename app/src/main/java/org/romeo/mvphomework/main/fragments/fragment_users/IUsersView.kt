package org.romeo.mvphomework.main.fragments.fragment_users

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUsersView : MvpView {
    fun init()

    fun updateList()
}