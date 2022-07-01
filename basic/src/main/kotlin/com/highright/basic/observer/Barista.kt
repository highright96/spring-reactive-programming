package com.highright.basic.observer

import java.util.Observable

class Barista : Observable() {

    private fun makeCoffee(name: String) = Coffee(name)

    fun serve(name: String) {
        setChanged()
        notifyObservers(makeCoffee(name))
    }
}