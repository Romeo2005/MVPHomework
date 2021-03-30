package org.romeo.mvphomework.base.base_list

import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface ListMessageShower {
    fun showMessage(message: String)
}