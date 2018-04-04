package com.jzheadley.kotlin.presentation

fun main(args: Array<String>) {// basic function
    val a = 1 // variables defined with val are constants and cannot be reassigned
    val b: Int = 2
    var c = 3 // variables defined with var are just like normal java variables
    c = 2
    functions(a, b)
    stringTemplates()
    println("max of 2 and 3 is ${myMax(2, 3)}")
    println("ternary max of 2 and 3 is ${myMaxTernary(2, 3)}")
    println("max of 2.1 and 3.2 is ${myMax(2.1, 3.2)}")
    println("max of 1, 3, and 4 is ${myMax(1, 3, 4)}")
    println("max of 2.1 and 3 is ${myMax(2.1, 3)}")

}

fun stringTemplates() {
    var a = 1
    // simple string temple
    val s1 = "a is $a"

    a = 2
    // functions in the string template
    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)

}

fun functions(a: Int, b: Int): Int { // return type can be omitted if return is void/Unit
    val sum = a + b

    println("sum of $a and $b is $sum") // string interpretation
    return sum
}

fun functions2(a: Int, b: Int): Int = a + b

// this function gives max whether its an Int or a Double
// we have this weird chain of ifs and else's because there is no ternary operator in kotlin.
// Which is my opinion is alright because statements using the ternary operator were difficult to read.
fun myMax(x: Number = 0.0, y: Number = 0.0, z: Number = 0.0): Number {
    return if (x > y) if (x > z) x else z else if (y > z) y else z
}

/**
 * operator overloading so the myMax function above is possible
 */
// have to return int because the operator returns an Int normally
private operator fun Number.compareTo(y: Number): Int = (this.toDouble() - y.toDouble()).toInt()
// the this in this function refers to the first variable in the compareTo since usually its called like a.compareTo(b)


// if you really want a ternary operator just implement it yourself like so...
infix fun <T : Any> Boolean.t(value: T): T? = if (this) value else null

// heres a working ternary function using infix functions
// this uses the elvis operator ?: to return the right hand value if the left is null
// due to this the ternary operator works by evaluating the boolean  and returning
// the first value if the boolean is true and null if not.  That null then gets evaluated by the elvis operator
fun myMaxTernary(x: Int = 0, y: Int = 0): Int = (x > y) t x ?: y
// we can also see how we can omit the braces and return keyword if its a one liner

