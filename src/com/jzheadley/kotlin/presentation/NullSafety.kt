package com.jzheadley.kotlin.presentation

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    val p: Person? = Person(Country("ENG"))

    // if the country or code objects are null this will return a null to the assignment of res
    var res = p!!.country?.code

    assertEquals(res, "ENG")


    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()

    var l: Int = if (intList != null) intList.size else -1
    l = intList?.size ?: -1

    letExample()

}

fun letExample() {
    val names: List<String?> = listOf("Tom", null, "Michael")
    // executes only when reference holds non-nullable value
    var result = listOf<String?>()
    for (item in names) {
        // essentially this is just a filter operation and can be done with a .filter
        // but this can be extended for other use obviously

        // it refers to the current item and is just a thing kotlin has
        item?.let { result = result.plus(it);it } // executes the action on all non-nullable element
                ?.also { it -> println("non nullable value: $it") } // calls this function on all non-null values
    }
    println("$result")
}

data class Person(var country: Country?)

data class Country(var code: String?)

val aInt: Int? = "1" as? Int
