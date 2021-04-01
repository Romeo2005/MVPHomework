package org.romeo.mvphomework.main.fragments.fragment_user

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import moxy.ktx.moxyPresenter
import org.romeo.mvphomework.base.base_fragment.BaseFragment
import org.romeo.mvphomework.databinding.FragmentUserBinding
import org.romeo.mvphomework.main.fragments.image.GlideImageLoader
import org.romeo.mvphomework.main.fragments.USER_KEY
import org.romeo.mvphomework.main.fragments.fragment_user.repos_list.ReposAdapter
import org.romeo.mvphomework.model.github.repository.repo.ReposRepository
import org.romeo.mvphomework.model.github.network.api.ApiHolder
import org.romeo.mvphomework.model.github.room.db.GithubDb
import org.romeo.mvphomework.model.github.storage.repo.RepoDbWorker
import org.romeo.mvphomework.model.github.storage.repo.RepoStorage
import org.romeo.mvphomework.model.image.ImageLoader
import org.romeo.mvphomework.navigation.App
import org.romeo.mvphomework.base.base_view.BackPressedListener
import org.romeo.mvphomework.main.fragments.image.AndroidImageStorage
import org.romeo.mvphomework.main.fragments.image.AndroidImageWorker
import org.romeo.mvphomework.model.image.db.MainImageDbWorker
import org.romeo.mvphomework.navigation.screens.Screens
import javax.inject.Inject

class UserFragment :
    BaseFragment<FragmentUserBinding>(), IUserView, BackPressedListener {

    @Inject
    lateinit var imageLoader: ImageLoader<ImageView>

    private val presenter: IUserPresenter? by moxyPresenter {
        UserPresenter(
            arguments?.getParcelable(USER_KEY)
        ).apply { App.instance.mainComponent.inject(this) }
    }

    private val lAdapter: ReposAdapter? by lazy {
        presenter?.let { ReposAdapter(it.listPresenter) }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.instance.mainComponent.inject(this)
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