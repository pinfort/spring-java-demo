package com.example.demo.controller;

import com.example.demo.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

    public static final String template = "Hello, %s!";
    public final AtomicInteger id = new AtomicInteger();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(id.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/")
    public String index() {
        return id.toString();
    }
}
