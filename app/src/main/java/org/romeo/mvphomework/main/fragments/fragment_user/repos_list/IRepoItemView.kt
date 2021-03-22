package org.romeo.mvphomework.main.fragments.fragment_user.repos_list

import org.romeo.mvphomework.base.base_list.IItemView

interface IRepoItemView : IItemView{
    fun setName(name: String)
}