package com.jzheadley.kotlin.presentation

import kotlin.system.measureNanoTime
// http://www.baeldung.com/kotlin-tail-recursion source for this part
fun main(args: Array<String>) {
    println("With a normal recursive factorial we finish in ${measureNanoTime { recursiveFactorial(100) }} nanoseconds")
    println("With tail recursion factorial we finish in ${measureNanoTime { factorial(100) }} nanoseconds")

}


fun recursiveFactorial(n: Long): Long {
    return if (n <= 1) {
        n
    } else {
        n * recursiveFactorial(n - 1)
    }
}

tailrec fun factorial(n: Long, fact: Long = 1): Long {
    val total = n * fact
    return if (n <= 1) {
        fact
    } else {
        factorial(n - 1, fact)
    }
}
