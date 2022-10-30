package com.thk.demoproj.model

import java.time.LocalDateTime

data class PostDto(
    val postId: Int = 0,
    val title: String,
    val content: String,
    val writer: String,
    val timestamp: LocalDateTime = LocalDateTime.now()
)
