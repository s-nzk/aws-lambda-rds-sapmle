package com.nzk;

import java.util.HashMap;
import java.util.Map;

public class Response {
    public int statusCode;
    public Map<String, String> headers = new HashMap<>();
    public String body;

    public int getStatusCode() {
        return statusCode;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public String getBody() {
        return body;
    }


    public void setBody(String body) {
        this.body = body;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}
