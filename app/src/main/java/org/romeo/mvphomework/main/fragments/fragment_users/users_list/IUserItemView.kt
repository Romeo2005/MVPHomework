package org.romeo.mvphomework.main.fragments.fragment_users.users_list

import org.romeo.mvphomework.base.base_list.IItemView
import org.romeo.mvphomework.base.base_list.ListMessageShower

interface IUserItemView : IItemView, ListMessageShower {
    fun setUsername(username: String)

    fun setAvatar(url: String)
}
