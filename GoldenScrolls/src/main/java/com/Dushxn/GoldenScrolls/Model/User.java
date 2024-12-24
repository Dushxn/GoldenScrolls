package com.Dushxn.GoldenScrolls.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private LocalDate DOB;

    @Column(nullable = false)
    private String userRole;

    private int contactNo;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public String getUserRole() {
        return userRole;
    }

    public int getContactNo() {
        return contactNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
