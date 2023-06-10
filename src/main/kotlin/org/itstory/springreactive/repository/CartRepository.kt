package org.itstory.springreactive.repository

import org.itstory.springreactive.entity.Cart
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface CartRepository : ReactiveCrudRepository<Cart, String> {
}