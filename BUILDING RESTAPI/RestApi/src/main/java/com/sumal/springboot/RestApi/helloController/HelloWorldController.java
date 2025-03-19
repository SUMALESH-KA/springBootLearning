package com.sumal.springboot.RestApi.helloController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {  // Class name should be PascalCase


    @GetMapping(value = "/hello-world")
    public String helloWorld() {  // Method name should be camelCase
        return "hello world";
    }

    @GetMapping(value = "/hello-worldbean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name) {  // Fix the method name
        return new HelloWorldBean("hello THIS" + name);
    }
}
