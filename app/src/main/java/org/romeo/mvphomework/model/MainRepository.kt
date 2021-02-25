package org.romeo.mvphomework.model

object MainRepository : Repository {
    override val values: Array<Int> = Array(3) { 0 }

    override fun increase1() = ++values[0]


    override fun increase2() = ++values[1]


    override fun increase3() = ++values[2]


    override fun get1() = values[0]

    override fun get2() = values[1]

    override fun get3() = values[2]
}