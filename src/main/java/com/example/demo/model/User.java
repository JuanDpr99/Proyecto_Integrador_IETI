package com.example.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class User {
    private String id;

    @NotBlank @Size(min = 2, max = 60)
    private String firstName;

    @NotBlank @Size(min = 2, max = 60)
    private String lastName;

    @NotBlank @Email
    private String email;

    @NotBlank @Size(min = 7, max = 20)
    private String phone;

    public User() {}
    public User(String id, String firstName, String lastName, String email, String phone) {
        this.id = id; this.firstName = firstName; this.lastName = lastName; this.email = email; this.phone = phone;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
}