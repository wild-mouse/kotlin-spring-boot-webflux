package com.wildmouse.demo

import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Mono

@Component
class HelloWorldHandler {
    fun helloWorld(request: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok()
                    .contentType(MediaType.TEXT_PLAIN)
                    .body(BodyInserters.fromObject("Hello, World."))
}