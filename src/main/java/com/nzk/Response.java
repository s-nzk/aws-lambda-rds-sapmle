package com.nzk;

import java.util.HashMap;
import java.util.Map;

public class Response {
    public int statusCode;
    public Map<String, String> headers = new HashMap<>();
    public String body;

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }


    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
