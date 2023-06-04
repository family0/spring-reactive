package org.itstory.springreactive.data

class Dish(
    var description: String,
    var delivered: Boolean = false,
) {
    companion object {
        fun deliver(dish: Dish) = Dish(dish.description, true)
    }
}