package com.wildmouse.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

//@Configuration
class HelloWorldRouter(private val helloWorldHandler: HelloWorldHandler) {
    @Bean
    fun helloWorldRouter() = router {
        GET("/", helloWorldHandler::helloWorld)
    }
}