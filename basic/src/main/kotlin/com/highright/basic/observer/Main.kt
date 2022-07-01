package com.highright.basic.observer

fun main() {
    val barista = Barista()
    val customer = Customer()

    barista.addObserver(customer)
    barista.serve(customer.orderCoffee())
}