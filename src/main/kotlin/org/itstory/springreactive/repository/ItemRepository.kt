package org.itstory.springreactive.repository

import org.itstory.springreactive.entity.Item
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ItemRepository : ReactiveCrudRepository<Item, String> {
}