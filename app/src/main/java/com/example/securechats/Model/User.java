package com.example.securechats.Model;

public class User {

    private String id;
    private String username;
    private String imgURL;
    private String status;
    private String about;

    public User(String id, String username, String imgURL, String status, String about) {
        this.id = id;
        this.username = username;
        this.imgURL = imgURL;
        this.status = status;
        this.about = about;
    }

    public User() {
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
