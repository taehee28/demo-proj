package com.thk.demoproj.model

data class PostDto(
    val postId: Int = 0,
    val title: String,
    val content: String,
    val timestamp: Long = 0
)
