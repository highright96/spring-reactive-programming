package com.highright.basic.completable_future

import java.util.concurrent.CompletableFuture

fun main() {
    /*
    val completableFuture = CompletableFuture.supplyAsync { // (1)
        Calculator.sum(100, 200, delay = 2000)
    }

    println("계산 시작")
    completableFuture.thenApply {
        println(it)
    }

    while (!completableFuture.isDone) { // (3)
        Thread.sleep(500)
        println("계산 결과를 집계 중입니다.")
    }
    println("계산 종료")
    */

    val startTime = System.nanoTime()

    println("계산 시작")

    (0 until 5).map {
        val supplier = {
            println("current-thread-name:${Thread.currentThread().name}")
            Calculator.sum(100, 200, delay = 2000)
        }
        CompletableFuture.supplyAsync(supplier)
    }
        .map(CompletableFuture<Int>::join)
        .forEach(::println)

    println("계산 종료")

    val elapsedTime = (System.nanoTime() - startTime) / 1_000_000

    println("수행시간 : $elapsedTime msecs")
}