package org.romeo.mvphomework.main.fragments.fragment_user

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserView : MvpView {
    fun setUsernameText(username: String)
}