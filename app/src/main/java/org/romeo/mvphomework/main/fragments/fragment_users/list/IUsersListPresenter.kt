package org.romeo.mvphomework.main.fragments.fragment_users.list

import org.romeo.mvphomework.base.base_list.IListPresenter
import org.romeo.mvphomework.model.entities.User

interface IUsersListPresenter :
    IListPresenter<User, UsersListAdapter.UserViewHolder>, UserItemClickListener