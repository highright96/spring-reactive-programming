package com.highright.basic.observer

import java.util.*

class Customer : Observer {

    fun orderCoffee() = "Iced Americano"

    override fun update(o: Observable?, arg: Any?) {
        val coffee = arg as Coffee
        println("I got a coffee ${coffee.name}")
    }
}