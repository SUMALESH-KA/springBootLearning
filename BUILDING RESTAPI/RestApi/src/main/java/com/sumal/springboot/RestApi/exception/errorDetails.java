package com.sumal.springboot.RestApi.exception;

import java.time.LocalDate;

public class errorDetails {
    private LocalDate timeStamp;
    private String message;
    private String details;

    public errorDetails( LocalDate timeStamp , String message, String details) {
        this.message = message;
        this.timeStamp = timeStamp;
        this.details = details;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "errorDetails{" +
                "timeStamp=" + timeStamp +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
