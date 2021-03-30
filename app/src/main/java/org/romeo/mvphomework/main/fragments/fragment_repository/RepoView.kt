package org.romeo.mvphomework.main.fragments.fragment_repository

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface RepoView : MvpView {
    fun showRepoLanguage(language: String)
}