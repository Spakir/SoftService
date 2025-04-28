package com.example.testing.softservice.model;

public class RequestData {

    String pathFile;
    int n;

    public RequestData(String pathFile, int n) {
        this.pathFile = pathFile;
        this.n = n;
    }

    public String getPathFile() {
        return pathFile;
    }

    public int getN() {
        return n;
    }
}
