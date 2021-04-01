package org.romeo.mvphomework.main.fragments.fragment_users.users_list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import org.romeo.mvphomework.databinding.ItemUserBinding
import org.romeo.mvphomework.model.image.ImageLoader
import javax.inject.Inject

class UsersListAdapter(
    private val presenter: IUsersListPresenter,
) :
    RecyclerView.Adapter<UsersListAdapter.UserViewHolder>(), UpdateListener {

    private lateinit var context: Context

    @Inject
    lateinit var imageLoader: ImageLoader<ImageView>

    inner class UserViewHolder(
        private val binding: ItemUserBinding,
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
            try {
                imageLoader.load(url, binding.avatarImg)
            } catch (e: Throwable) {
                presenter.processError(e, this)
            }

        }

        override val num: Int
            get() = adapterPosition

        override fun showMessage(message: String) {
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        context = parent.context

        return UserViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bind(position, holder)
    }

    override fun getItemCount() = presenter.itemsNumber

    override val onUpdate = {
        notifyDataSetChanged()
    }
}