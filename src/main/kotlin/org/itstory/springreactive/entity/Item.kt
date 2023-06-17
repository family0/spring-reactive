package org.itstory.springreactive.entity

import org.springframework.data.annotation.Id
import org.springframework.data.geo.Point
import java.time.LocalDate

class Item(
    @Id
    var id: String? = null,
    var name: String,
    var description: String,
    var price: Double,
)