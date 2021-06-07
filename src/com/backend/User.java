package com.backend;

import javafx.beans.property.SimpleStringProperty;

public class User {

    private final int iQueID;

    private SimpleStringProperty firstName, surname;
    private String email;
    private String address;
    private String password;


    public User(int iQueID, SimpleStringProperty firstName, SimpleStringProperty surname, String email, String address, String password) {
        this.iQueID = iQueID;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public int getiQueID() {
        return iQueID;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getSurname() {
        return surname.get();
    }

    public SimpleStringProperty surnameProperty() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.set(surname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
