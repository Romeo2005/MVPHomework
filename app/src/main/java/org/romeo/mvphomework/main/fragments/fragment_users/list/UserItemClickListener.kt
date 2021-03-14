package org.romeo.mvphomework.main.fragments.fragment_users.list

import org.romeo.mvphomework.base.base_list.IListPresenter


/**
 *  If listeners for specific views from item are needed,
 *  they should be declared here.
 */
interface UserItemClickListener :
    IListPresenter.ListItemClickListener<UsersListAdapter.UserViewHolder>