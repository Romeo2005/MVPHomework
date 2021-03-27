package org.romeo.mvphomework.main.fragments.fragment_users.users_list

import org.romeo.mvphomework.base.base_list.IListPresenter
import org.romeo.mvphomework.model.github.entities.GithubUser

interface IUsersListPresenter :
    IListPresenter<GithubUser, IUserItemView>, UserItemClickListener