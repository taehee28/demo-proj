package com.thk.demoproj.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
class DemoController {
    @GetMapping("/")
    fun index() = "index"
}