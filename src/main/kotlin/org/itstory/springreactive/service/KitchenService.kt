package org.itstory.springreactive.service

import org.itstory.springreactive.data.Dish
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration

@Service
class KitchenService {
    fun getDishes(): Flux<Dish> {
        return Flux.generate { sink -> sink.next(randomDish()) }
            .delayElements(Duration.ofMillis(500))
    }

    fun randomDish(): Dish {
        return Dish("abc")
    }
}