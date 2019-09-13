package com.wildmouse.demo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.RouterFunction
import org.springframework.web.reactive.function.server.RouterFunctions
import org.springframework.web.reactive.function.server.ServerResponse

@Configuration
class RouteConfig {
    @Bean
    fun routes(helloWorldHandler: HelloWorldHandler): RouterFunction<ServerResponse> {
        return RouterFunctions.route()
                .GET("/", helloWorldHandler::helloWorld)
                .POST("/", helloWorldHandler::postSomething)
                .PUT("/", helloWorldHandler::putSomething)
                .build()
    }
}