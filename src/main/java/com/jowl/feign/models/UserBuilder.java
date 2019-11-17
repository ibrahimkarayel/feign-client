package com.jowl.feign.models;


public class UserBuilder {
    private String firstName;
    private String lastName;
    private String displayName;
    private String email;
    private String password;

    public UserBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public UserBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public UserBuilder setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public UserBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password) {
        this.password = password;
        return this;
    }


    public User createUser() {
        return new User(firstName, lastName, displayName, email, password);
    }
}
