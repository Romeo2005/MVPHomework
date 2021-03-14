package org.romeo.mvphomework.main.fragments.fragment_users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.databinding.FragmentUsersBinding
import org.romeo.mvphomework.main.fragments.fragment_users.list.UsersListAdapter
import org.romeo.mvphomework.model.UsersRepository
import org.romeo.mvphomework.navigation.App
import org.romeo.mvphomework.navigation.BackPressedListener
import org.romeo.mvphomework.navigation.Screens

class UsersFragment : IUsersView, BaseFragment<FragmentUsersBinding>(), BackPressedListener {

    private val presenter: IUsersPresenter by moxyPresenter {
        UsersPresenter(App.instance.router, UsersRepository, Screens)
    }

    private val lAdapter by lazy { UsersListAdapter(presenter.listPresenter) }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.let { binding ->
            binding.newUserButton.setOnClickListener {
                presenter.addUserPressed(binding.usernameText.text.toString())
            }
        }
    }
}