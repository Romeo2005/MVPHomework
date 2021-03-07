package org.romeo.mvphomework.base.base_list

interface IListPresenter<I, VH> {
    var items: List<I>

    val itemsNumber: Int

    fun bind(pos: Int, item: VH)

    interface ListItemClickListener<I> {

        var onClick: ((I) -> Unit)?
    }
}