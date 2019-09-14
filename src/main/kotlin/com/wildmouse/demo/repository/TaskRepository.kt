package com.wildmouse.demo.repository

import com.wildmouse.demo.model.Task
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository: ReactiveMongoRepository<Task, String>
