package com.thk.demoproj.controller

import com.thk.demoproj.model.PostDto
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*
import java.time.LocalDateTime

@Controller
class DemoController {
    @GetMapping("/")
    fun index(model: Model): String {
        val list = listOf(
            PostDto(0, "title1", "content1", "aaa", LocalDateTime.now()),
            PostDto(0, "title2", "content1", "bbb", LocalDateTime.now()),
            PostDto(0, "title3", "content1", "ccc", LocalDateTime.now()),
            PostDto(0, "title4", "content1", "ddd", LocalDateTime.now()),
        )

        model["postList"] = list

        return "index"
    }
}