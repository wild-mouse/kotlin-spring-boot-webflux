package com.wildmouse.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.*
import reactor.core.publisher.Flux

@SpringBootApplication
class DemoApplication {
    @Bean
    fun routes(): RouterFunction<ServerResponse> {
        return RouterFunctions.route(
                RequestPredicates.GET("/"),
                HandlerFunction { _ -> ServerResponse.ok().body(Flux.just("Hello, World!")) }
        )
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
