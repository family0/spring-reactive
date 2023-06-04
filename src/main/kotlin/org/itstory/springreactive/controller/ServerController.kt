package org.itstory.springreactive.controller

import org.itstory.springreactive.data.Dish
import org.itstory.springreactive.service.KitchenService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ServerController(
    private val kitchenSvc: KitchenService,
) {
    @GetMapping("/server", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun serveDishes(): Flux<Dish> {
        return kitchenSvc.getDishes()
    }

    @GetMapping("/served-dishes", produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun deliverDishes(): Flux<Dish> {
        return kitchenSvc.getDishes()
            .map { dish -> Dish.deliver(dish) }
    }
}