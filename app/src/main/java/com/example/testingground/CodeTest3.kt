package com.example.testingground

import kotlinx.coroutines.*

suspend fun timer(msg: String): String {
    delay(5000)
    return "Timer finished for $msg"
}

fun main() = runBlocking {
    val result = timer("testing")
    println(result)
}
