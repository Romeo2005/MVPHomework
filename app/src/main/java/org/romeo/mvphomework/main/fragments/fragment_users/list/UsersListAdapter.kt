package org.romeo.mvphomework.main.fragments.fragment_users.list

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import org.romeo.mvphomework.databinding.ItemUserBinding
import org.romeo.mvphomework.main.GlideImageLoader
import org.romeo.mvphomework.model.image.ImageLoader

class UsersListAdapter(private val presenter: IUsersListPresenter) :
    RecyclerView.Adapter<UsersListAdapter.UserViewHolder>(), UpdateListener {

    inner class UserViewHolder(
        private val binding: ItemUserBinding,
        private val imageLoader: ImageLoader<ImageView>
    ) : RecyclerView.ViewHolder(binding.root), IUserItemView {

        init {
            binding.root.setOnClickListener {
                presenter.onClick?.invoke(this)
            }
        }

        override fun setUsername(username: String) {
            binding.usernameText.text = username
        }

        override fun setAvatar(url: String) {
            imageLoader.load(url, binding.avatarImg)
        }
    }

    init {
        presenter.updateListener = this
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder =
        UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            GlideImageLoader()
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bind(position, holder)
    }

    override fun getItemCount() = presenter.itemsNumber

    override val onUpdate = {
        notifyDataSetChanged()
    }
}