package org.romeo.mvphomework.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.romeo.mvphomework.databinding.ActivityMainBinding
import org.romeo.mvphomework.model.MainRepository

class MainActivity : AppCompatActivity(), MainView {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val presenter: MainPresenter by lazy { MainPresenter(this, MainRepository) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        presenter.initViews()

        binding.button1.setOnClickListener {
            presenter.pressed1()
        }

        binding.button2.setOnClickListener {
            presenter.pressed2()
        }

        binding.button3.setOnClickListener {
            presenter.pressed3()
        }
    }

    override fun setText1(text: String) {
        binding.button1.text = text
    }

    override fun setText2(text: String) {
        binding.button2.text = text
    }

    override fun setText3(text: String) {
        binding.button3.text = text
    }
}