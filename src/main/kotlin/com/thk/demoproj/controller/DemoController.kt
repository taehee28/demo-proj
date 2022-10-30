package com.thk.demoproj.controller

import com.thk.demoproj.model.PostDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Controller
class DemoController {
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
        list.add(post)
        return "redirect:/list"
    }
}