package com.wildmouse.demo

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
class HelloWorldHandler {
    fun helloWorld(request: ServerRequest): Mono<ServerResponse> =
            ok().body(Flux.just("Hello, World!"))
}