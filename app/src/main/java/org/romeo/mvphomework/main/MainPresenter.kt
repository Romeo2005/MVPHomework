package org.romeo.mvphomework.main

import org.romeo.mvphomework.model.Repository

class MainPresenter(private val view: MainView, private val repository: Repository) {

    fun pressed1() {
        view.setText1(repository.increase1().toString())
    }

    fun pressed2() {
        view.setText2(repository.increase2().toString())
    }

    fun pressed3() {
        view.setText3(repository.increase3().toString())
    }

    fun initViews() {
        view.setText1(repository.get1().toString())
        view.setText2(repository.get2().toString())
        view.setText3(repository.get3().toString())
    }
}