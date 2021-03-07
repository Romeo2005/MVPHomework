package org.romeo.mvphomework.base.base_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import moxy.MvpAppCompatFragment
import org.romeo.mvphomework.databinding.FragmentUserBinding
import kotlin.reflect.KClass

open class BaseFragment<B : ViewBinding> : MvpAppCompatFragment() {
    protected var binding: B? = null

/*    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =*/

    companion object {
        inline fun <reified T : BaseFragment<out ViewBinding>> newInstance(args: Bundle? = null): T {
            val c = T::class.java
            val fragment = c.newInstance()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}