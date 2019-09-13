package com.wildmouse.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.reactive.function.server.*
import org.springframework.web.reactive.function.server.RouterFunctions.route

@SpringBootApplication
class DemoApplication {
    @Bean
    fun routes(helloWorldHandler: HelloWorldHandler): RouterFunction<ServerResponse> {
        return route()
                .GET("/", helloWorldHandler::helloWorld)
                .build()
//        )
    }
}

fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}
