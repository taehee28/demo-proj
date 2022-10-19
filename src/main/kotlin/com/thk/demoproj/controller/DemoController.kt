package com.thk.demoproj.controller

import com.thk.demoproj.model.PostDto
import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
class DemoController {
    private val list = mutableListOf<PostDto>()

    @GetMapping("/")
    fun index() = "hello world"

    @GetMapping("/bbs/list")
    fun getPostList() = list

    @PutMapping("/bbs/write")
    fun putPost(@RequestBody post: PostDto) =
        list.add(post.copy(timestamp = System.currentTimeMillis()))

    @DeleteMapping("/bbs/delete")
    fun deletePost(@RequestParam("postId") postId: Int) {
        val post = list.find { it.postId == postId }
        list.remove(post)
    }
}