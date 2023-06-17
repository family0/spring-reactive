package org.itstory.springreactive.repository

import org.itstory.springreactive.entity.Item
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ItemRepository : ReactiveCrudRepository<Item, String>, ReactiveQueryByExampleExecutor<Item> {
}