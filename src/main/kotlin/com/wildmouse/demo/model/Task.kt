package com.wildmouse.demo.model

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "task")
data class Task(
        var id: String = "",
        var task: String = ""
)