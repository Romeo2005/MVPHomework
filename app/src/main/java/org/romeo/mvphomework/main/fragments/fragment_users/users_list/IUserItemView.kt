package org.romeo.mvphomework.main.fragments.fragment_users.users_list

import org.romeo.mvphomework.base.base_list.IItemView

interface IUserItemView : IItemView {
    fun setUsername(username: String)

    fun setAvatar(url: String)
}
