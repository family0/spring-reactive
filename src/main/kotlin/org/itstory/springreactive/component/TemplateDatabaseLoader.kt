package org.itstory.springreactive.component

import org.itstory.springreactive.entity.Item
import org.springframework.boot.CommandLineRunner
import org.springframework.context.annotation.Bean
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.stereotype.Component

@Component
class TemplateDatabaseLoader {
    @Bean
    fun initialize(mongo: MongoOperations): CommandLineRunner {
        return CommandLineRunner { args ->
            mongo.save(Item(null, "Alf alarm clock", "clock description", 2000.0))
            mongo.save(Item(null, "Smurf TV tray", "abcd", 1500.0))
        }
    }
}