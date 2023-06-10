package org.itstory.springreactive.entity

import org.springframework.data.annotation.Id

class Item(
    @Id
    var id: String? = null,
    var name: String,
    var price: Double,
)