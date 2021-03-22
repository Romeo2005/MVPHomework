package org.romeo.mvphomework.main.fragments.fragment_user.repos_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.romeo.mvphomework.databinding.ItemRepoBinding

class ReposAdapter(private val presenter: IReposListPresenter) :
    RecyclerView.Adapter<ReposAdapter.ReposViewHolder>() {

    class ReposViewHolder(private val binding: ItemRepoBinding) :
        RecyclerView.ViewHolder(binding.root), IRepoItemView {

        override fun setName(name: String) {
            binding.nameText.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReposViewHolder =
        ReposViewHolder(
            ItemRepoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ReposViewHolder, position: Int) {
        presenter.bind(position, holder)
    }

    override fun getItemCount() = presenter.itemsNumber
}