package com.thk.demoproj.controller

import com.thk.demoproj.model.PostDto
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@Controller
class DemoController(
    private val passwordEncoder: PasswordEncoder
) {
    val list = mutableListOf<PostDto>()

    @GetMapping("/list")
    fun index(model: Model): String {
        model["postList"] = list

        return "index"
    }

    @GetMapping("/write")
    fun writeForm(): String {
        return "write"
    }

    @PostMapping("/write")
    fun writePost(post: PostDto): String {
        list.add(
            post.copy(
                postId = list.size.plus(1),
                password = passwordEncoder.encode(post.password)
            )
        )
        return "redirect:/list"
    }

    @GetMapping("/detail/{postId}")
    fun detail(@PathVariable("postId") postId: Int, model: Model): String {
        for (post in list) {
            if (post.postId == postId) {
                model["post"] = post
                break
            }
        }

        return "detail"
    }
}