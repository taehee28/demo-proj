package com.thk.demoproj.controller

import org.springframework.web.bind.annotation.*
import javax.annotation.PostConstruct

@RestController
class DemoController {
    lateinit var map: MutableMap<String, String>

    @PostConstruct
    fun init() {
        map = mutableMapOf("a" to "apple", "b" to "banana", "c" to "cherry")
    }

    @GetMapping("/hello")
    fun getHelloWorld() = "Hello world!"

    @GetMapping("/map/{key}")
    fun getValue(@PathVariable("key") key: String) = map[key]

    @GetMapping("/map/all")
    fun getValues() = map

    @PutMapping("/map/{key}")
    fun putValue(
        @PathVariable("key") key: String,
        @RequestParam("value") value: String
    ) {
        map[key] = value
    }

    @DeleteMapping("/map/{key}")
    fun deleteValue(@PathVariable("key") key: String) {
        map.remove(key)
    }
}