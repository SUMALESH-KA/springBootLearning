package com.sumal.springboot.RestApi.helloController;

public class HelloWorldBean {
    private final String message;

    public HelloWorldBean(String message) {
        this.message = message;
    }

    public String getMessage() {  // Must have a getter
        return message;
    }

    @Override
    public String toString() {
        return "HelloWorldBean{" +
                "message='" + message + '\'' +
                '}';
    }
}
