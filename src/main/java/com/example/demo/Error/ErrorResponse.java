package com.example.demo.Error;

import java.time.LocalDateTime;
import java.util.List;

public class ErrorResponse {

    private Boolean success;
    private String message;
    private LocalDateTime dateTime;
    private List<String> details;

    public ErrorResponse() {

    }


    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
        this.success = Boolean.FALSE;
        this.dateTime = LocalDateTime.now();
    }

    public Boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public List<String> getDetails() {
        return details;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDetails(List<String> details) {
        this.details = details;
    }
}
