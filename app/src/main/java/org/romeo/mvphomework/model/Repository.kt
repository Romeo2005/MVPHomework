package org.romeo.mvphomework.model

interface Repository {
    val values: Array<Int>

    fun increase1(): Int
    fun increase2(): Int
    fun increase3(): Int

    fun get1(): Int
    fun get2(): Int
    fun get3(): Int
}