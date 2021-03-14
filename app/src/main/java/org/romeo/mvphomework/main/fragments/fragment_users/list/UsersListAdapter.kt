package org.romeo.mvphomework.main.fragments.fragment_users.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.romeo.mvphomework.databinding.ItemUserBinding
import org.romeo.mvphomework.model.entities.User

class UsersListAdapter(private val presenter: IUsersListPresenter) :
    RecyclerView.Adapter<UsersListAdapter.UserViewHolder>(), UpdateListener {

    inner class UserViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root), IUserItemView {

        init {
            binding.root.setOnClickListener {
                presenter.onClick?.invoke(this)
            }
        }

        override fun setUsername(username: String) {
            binding.usernameText.text = username
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
            )
        )

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        presenter.bind(position, holder)
    }

    override fun getItemCount() = presenter.itemsNumber

    override val onUpdate = {
        notifyDataSetChanged()
    }
}