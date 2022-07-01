package com.highright.reactor3

import reactor.core.publisher.Flux

data class Cellphone(
    val name: String,
    val price: Int,
    val currency: Currency
)

enum class Currency {
    KRW, USD
}

fun main() {
    val iphone = Cellphone(
        name = "name1",
        price = 100,
        currency = Currency.KRW
    )

    val galaxy = Cellphone(
        name = "name2",
        price = 200,
        currency = Currency.USD
    )

    val flux: Flux<Cellphone> = Flux.just(iphone, galaxy)
    flux.subscribe { println(it) }
}