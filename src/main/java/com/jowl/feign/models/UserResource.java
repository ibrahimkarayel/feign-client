package com.jowl.feign.models;

public class UserResource {
    private User user;

    public UserResource() {
    }

    public UserResource(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
