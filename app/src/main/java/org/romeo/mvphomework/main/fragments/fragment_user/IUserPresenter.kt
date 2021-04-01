package org.romeo.mvphomework.main.fragments.fragment_user

import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.IReposListPresenter
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.base.base_view.BackPressedListener

interface IUserPresenter : BackPressedListener {
    val listPresenter: IReposListPresenter
    fun navigateToRepoFragment(data: Map<String, GithubRepo>)
}