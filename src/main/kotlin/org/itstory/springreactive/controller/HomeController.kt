package org.itstory.springreactive.controller

import org.itstory.springreactive.entity.Cart
import org.itstory.springreactive.repository.CartRepository
import org.itstory.springreactive.repository.ItemRepository
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.reactive.result.view.Rendering
import reactor.core.publisher.Mono

@Controller
class HomeController(
    private val itemRepo: ItemRepository,
    private val cartRepo: CartRepository,
) {
    @GetMapping("/")
    fun home(): Mono<Rendering> {
        return Mono.just(
            Rendering.view("home.html")
                .modelAttribute("items", itemRepo.findAll())
                .modelAttribute("cart", cartRepo.findById("My Cart").defaultIfEmpty(Cart("My Cart")))
                .build())
    }
}