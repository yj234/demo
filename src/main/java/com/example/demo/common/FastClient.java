package com.example.demo.common;

public class FastClient {
    private String url;
    private String userName;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "FastClient{" +
                "url='" + url + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
