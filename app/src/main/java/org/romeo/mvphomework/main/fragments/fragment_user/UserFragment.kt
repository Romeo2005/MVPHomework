package org.romeo.mvphomework.main.fragments.fragment_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.databinding.FragmentUserBinding
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.navigation.App
import org.romeo.mvphomework.navigation.BackPressedListener
import org.romeo.mvphomework.navigation.Screens

class UserFragment : BaseFragment<FragmentUserBinding>(), IUserView, BackPressedListener {
    private val presenter: IUserPresenter? by moxyPresenter {
        UserPresenter(
            arguments?.getParcelable(USER_KEY),
            App.instance.router,
            Screens
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding
        .inflate(inflater, container, false)
        .also { binding = it }.root

    override fun setUsernameText(username: String) {
        binding?.usernameText?.text = username
    }

    override fun onBackPressed() = presenter?.onBackPressed() ?: false
}