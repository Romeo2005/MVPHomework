package org.romeo.mvphomework.main.fragments.fragment_repository

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.databinding.FragmentRepoBinding
import org.romeo.mvphomework.main.fragments.REPO_KEY
import org.romeo.mvphomework.model.github.entities.GithubRepo
import org.romeo.mvphomework.navigation.App

class RepoFragment : BaseFragment<FragmentRepoBinding>(), RepoView {

    private val presenter: RepoPresenter by moxyPresenter {
        RepoPresenter(
            arguments?.getParcelable(REPO_KEY)
        ).apply { App.instance.mainComponent.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentRepoBinding
        .inflate(inflater, container, false)
        .also { binding = it }.root

    override fun showRepoLanguage(language: String) {
        binding?.languageText?.text = language
    }
}