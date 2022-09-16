package com.example.hrmproject.entity;

public class FileInfo {
    private String fileName;
    private String message;
    private String url;

    public FileInfo() {
    }

    public FileInfo(String fileName, String message) {
        this.fileName = fileName;
        this.message = message;
    }

    public FileInfo(String message) {
        this.message = message;
    }

    public FileInfo(String fileName, String message, String url) {
        this.fileName = fileName;
        this.url = url;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }    
}
