package org.romeo.mvphomework.base.base_list

interface IListPresenter<I, V : IItemView> {
    var items: List<I>

    val itemsNumber: Int

    fun bind(pos: Int, item: V)

    interface ListItemClickListener<I> {
        var onClick: ((I) -> Unit)?
    }
}