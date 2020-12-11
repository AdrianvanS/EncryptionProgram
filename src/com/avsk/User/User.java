package com.avsk.User;

public class User {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    public User(String firstName, String lastName, String userName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {return password;}

}
