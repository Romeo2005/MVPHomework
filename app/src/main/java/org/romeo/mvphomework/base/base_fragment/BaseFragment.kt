package org.romeo.mvphomework.base.base_fragment

import android.os.Bundle
import android.os.Parcelable
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment

open class BaseFragment<B : ViewBinding> : MvpAppCompatFragment() {
    protected var binding: B? = null

    companion object {
        inline fun <reified T : BaseFragment<out ViewBinding>>
                newInstance(inArgs: Map<String, Parcelable>? = null): T {

            val c = T::class.java
            val fragment = c.newInstance()

            inArgs ?: let { return@newInstance fragment}

            val arguments = Bundle()

            for (p in inArgs)
                arguments.putParcelable(p.key, p.value)

            fragment.arguments = arguments

            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}