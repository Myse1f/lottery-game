package com.myse1f.lotterygame.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class Result {
    @JsonProperty("msg")
    private String message;

    @JsonProperty("code")
    private int code;

    @JsonProperty("data")
    private Map<String, String> data;

    public Result() {
        this.message = null;
        this.code = -1;
        this.data = null;
    }

    public Result(String message, int code, Map<String, String> data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public enum ResultCode{
        /**
         * success
         */
        SUCCESS(111, "Request Successfully."),

        /**
         * busy
         */
        BUSY(222, "Busy drawing the lottery."),

        /**
         * waiting
         */
        WAITING(333, "Waiting for settlement block."),

        /**
         * Exception happen inside backend
         */
        EXCEPTION(444, "Some exception happened.");

        private int code;
        private String errMsg;

        public int getCode()
        {
            return code;
        }

        public String getErrMsg(){
            return errMsg;
        }

        ResultCode(int code, String msg)
        {
            this.code = code;
            this.errMsg = msg;
        }
    }
}
