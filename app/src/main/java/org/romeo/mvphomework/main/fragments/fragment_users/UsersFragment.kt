package org.romeo.mvphomework.main.fragments.fragment_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.databinding.FragmentUsersBinding
import org.romeo.mvphomework.main.fragments.image.GlideImageLoader
import org.romeo.mvphomework.main.fragments.fragment_users.users_list.UsersListAdapter
import org.romeo.mvphomework.model.github.repository.user.UsersRepository
import org.romeo.mvphomework.model.github.network.api.ApiHolder
import org.romeo.mvphomework.model.github.room.db.GithubDb
import org.romeo.mvphomework.model.github.storage.user.UserDbWorker
import org.romeo.mvphomework.model.github.storage.user.UserStorage
import org.romeo.mvphomework.navigation.App
import org.romeo.mvphomework.base.base_view.BackPressedListener
import org.romeo.mvphomework.main.fragments.image.AndroidImageStorage
import org.romeo.mvphomework.main.fragments.image.AndroidImageWorker
import org.romeo.mvphomework.model.image.db.MainImageDbWorker
import org.romeo.mvphomework.navigation.screens.Screens

class UsersFragment : IUsersView, BaseFragment<FragmentUsersBinding>(), BackPressedListener {

    private val presenter: IUsersPresenter by moxyPresenter {
        UsersPresenter().apply {
            App.instance
                .mainComponent
                .inject(this)
        }
    }

    private val lAdapter by lazy {
        UsersListAdapter(
            presenter.listPresenter
        ).apply { App.instance.mainComponent.inject(this) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUsersBinding
        .inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onBackPressed() =
        presenter.onBackPressed()

    override fun init() {
        binding?.let { binding ->
            val rv = binding.usersRecycler
            rv.layoutManager = LinearLayoutManager(requireContext())
            rv.adapter = lAdapter
        }
    }

    override fun updateList() {
        lAdapter.notifyDataSetChanged()
    }
}