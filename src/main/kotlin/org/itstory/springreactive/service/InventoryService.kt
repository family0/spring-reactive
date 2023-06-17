package org.itstory.springreactive.service

import org.itstory.springreactive.entity.Item
import org.itstory.springreactive.repository.ItemRepository
import org.springframework.data.domain.Example
import org.springframework.data.domain.ExampleMatcher
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class InventoryService(
    private val itemRepo: ItemRepository,
) {
    fun searchByExample(name: String, description: String, useAnd: Boolean): Flux<Item> {
        val item = Item(null, name, description, 0.0)
        val matcher = if (useAnd) ExampleMatcher.matchingAll() else ExampleMatcher.matchingAny()
            .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
            .withIgnoreCase()
            .withIgnorePaths("price")
        val probe = Example.of(item, matcher)
        return itemRepo.findAll(probe)
    }
}