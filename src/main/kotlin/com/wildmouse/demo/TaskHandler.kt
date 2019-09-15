package com.wildmouse.demo

import com.wildmouse.demo.model.Task
import com.wildmouse.demo.repository.TaskRepository
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.notFound
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono

@Component
class TaskHandler(
        private val taskRepository: TaskRepository
) {
    fun getTasks(request: ServerRequest): Mono<ServerResponse> =
            ok().contentType(MediaType.APPLICATION_JSON)
                    .body(taskRepository.findAll())

    fun getTaskById(request: ServerRequest): Mono<ServerResponse> =
            taskRepository.findById(request.pathVariable("id"))
                    .flatMap { ok().body(BodyInserters.fromObject(it)) }
                    .switchIfEmpty(notFound().build())

    fun postTask(request: ServerRequest): Mono<ServerResponse> =
            request.bodyToMono(Task::class.java)
                    .flatMap { taskRepository.save(it) }
                    .flatMap { ok().body(BodyInserters.fromObject(it)) }

//    fun putSomething(reqeust: ServerRequest): Mono<ServerResponse> =
//            ok().build()
}

