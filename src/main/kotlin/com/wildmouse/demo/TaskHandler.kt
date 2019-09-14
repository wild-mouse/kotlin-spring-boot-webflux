package com.wildmouse.demo

import com.wildmouse.demo.repository.TaskRepository
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import reactor.core.publisher.Mono

@Component
class TaskHandler(
        private val taskRepository: TaskRepository
) {
    fun getTaskById(request: ServerRequest): Mono<ServerResponse> =
            taskRepository.findById(request.pathVariable("id"))
                    .flatMap { ok().body(BodyInserters.fromObject(it)) }
                    .switchIfEmpty(notFound().build())

//    fun postSomething(request: ServerRequest): Mono<ServerResponse> =
//            ok().build()
//
//    fun putSomething(reqeust: ServerRequest): Mono<ServerResponse> =
//            ok().build()
}

