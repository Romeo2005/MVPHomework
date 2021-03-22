package org.romeo.mvphomework.main.fragments.fragment_user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.databinding.FragmentUserBinding
import org.romeo.mvphomework.main.GlideImageLoader
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.ReposAdapter
import org.romeo.mvphomework.model.github.ReposRepository
import org.romeo.mvphomework.model.github.api.ApiHolder
import org.romeo.mvphomework.model.image.ImageLoader
import org.romeo.mvphomework.navigation.App
import org.romeo.mvphomework.navigation.BackPressedListener
import org.romeo.mvphomework.navigation.Screens

class UserFragment :
    BaseFragment<FragmentUserBinding>(), IUserView, BackPressedListener {

    private val imageLoader: ImageLoader<ImageView> = GlideImageLoader()

    private val presenter: IUserPresenter? by moxyPresenter {
        UserPresenter(
            arguments?.getParcelable(USER_KEY),
            ReposRepository(ApiHolder.dataSource),
            App.instance.router,
            Screens
        )
    }

    private val lAdapter: ReposAdapter? by lazy {
        presenter?.let { ReposAdapter(it.listPresenter) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserBinding
        .inflate(inflater, container, false)
        .also { binding = it }.root

    override fun onBackPressed() = presenter?.onBackPressed() ?: false

    override fun initReposList() {
        binding?.let { binding ->
            with(binding.reposRecycler) {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = lAdapter
            }
        }
    }

    override fun updateList() {
        lAdapter?.notifyDataSetChanged()
    }

    override fun setUsername(username: String) {
        binding?.usernameText?.text = username
    }

    override fun loadAvatar(url: String) {
        binding?.let { binding ->
            imageLoader.load(url, binding.avatarImg)
        }
    }
}