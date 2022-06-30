package com.israel.bookstorebackend.controller.exceptions;

public class StandardError {

    private Long timesStamp;

    private Integer status;

    private String error;

    public StandardError() {
    }

    public StandardError(Long timesStamp, Integer status, String error) {
        this.timesStamp = timesStamp;
        this.status = status;
        this.error = error;
    }

    public Long getTimesStamp() {
        return timesStamp;
    }

    public void setTimesStamp(Long timesStamp) {
        this.timesStamp = timesStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
