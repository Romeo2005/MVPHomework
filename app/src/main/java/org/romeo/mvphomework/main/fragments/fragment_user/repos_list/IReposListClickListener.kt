package org.romeo.mvphomework.main.fragments.fragment_user.repos_list

import org.romeo.mvphomework.base.base_list.IListPresenter
import org.romeo.mvphomework.model.github.entities.GithubRepo

interface IReposListClickListener : IListPresenter.ListItemClickListener<IRepoItemView> {
}