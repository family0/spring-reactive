package org.itstory.springreactive.entity

import org.springframework.data.annotation.Id

class Cart(
    @Id
    var id: String? = null,
    var cartItems: List<CartItem> = mutableListOf(),
)