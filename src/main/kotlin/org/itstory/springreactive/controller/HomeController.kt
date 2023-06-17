package org.itstory.springreactive.controller

import org.itstory.springreactive.entity.Cart
import org.itstory.springreactive.entity.CartItem
import org.itstory.springreactive.repository.CartRepository
import org.itstory.springreactive.repository.ItemRepository
import org.itstory.springreactive.service.CartService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.reactive.result.view.Rendering
import reactor.core.publisher.Mono

@Controller
class HomeController(
    private val itemRepo: ItemRepository,
    private val cartRepo: CartRepository,
    private val cartSvc: CartService,
) {
    @GetMapping("/")
    fun home(): Mono<Rendering> {
        return Mono.just(
            Rendering.view("home.html")
                .modelAttribute("items", itemRepo.findAll())
                .modelAttribute("cart", cartRepo.findById("My Cart").defaultIfEmpty(Cart("My Cart")))
                .build())
    }

    @PostMapping("/add/{id}")
    fun addToCart(@PathVariable id: String): Mono<String> {
        return cartSvc.addToCart("My Cart", id)
            .thenReturn("redirect:/")
    }
}