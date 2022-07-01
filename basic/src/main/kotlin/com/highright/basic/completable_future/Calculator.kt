package com.highright.basic.completable_future

object Calculator {
    fun sum(a: Int, b: Int, delay: Long = 0): Int {
        Thread.sleep(delay)
        return a + b
    }
}