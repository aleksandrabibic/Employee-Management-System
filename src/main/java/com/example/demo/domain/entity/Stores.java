package com.example.demo.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "stores")
public class Stores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String phoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Stores() {
    }

    public Stores(String name, String address, String phoneNumber, User user) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
