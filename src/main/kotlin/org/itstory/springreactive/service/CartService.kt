package org.itstory.springreactive.service

import org.itstory.springreactive.entity.Cart
import org.itstory.springreactive.entity.CartItem
import org.itstory.springreactive.repository.CartRepository
import org.itstory.springreactive.repository.ItemRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class CartService(
    private val itemRepo: ItemRepository,
    private val cartRepo: CartRepository,
) {
    fun addToCart(cartId: String, id: String): Mono<Cart> {
        return cartRepo.findById(cartId)
            .defaultIfEmpty(Cart(cartId))
            .flatMap { cart ->
                cart.cartItems.stream()
                    .filter { it.item.id == id }
                    .findAny()
                    .map {
                        it.quantity += 1
                        Mono.just(cart)
                    }.orElseGet {
                        itemRepo.findById(id)
                            .map { CartItem(it) }
                            .map {
                                cart.cartItems += it
                                cart
                            }
                    }
            }.flatMap { cartRepo.save(it) }
    }
}