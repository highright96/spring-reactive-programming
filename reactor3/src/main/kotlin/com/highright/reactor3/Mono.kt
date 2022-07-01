package com.highright.reactor3

import reactor.core.publisher.Mono

fun main() {
    val mono: Mono<String> = Mono.just("Hello world!")
    mono.subscribe {
        println(it)
    }

    val greeting: String? = null
    Mono.justOrEmpty(greeting)
        .switchIfEmpty(
            Mono.defer {
                Mono.just("Hello world!")
            }
        )
        .subscribe { println(it) }

}