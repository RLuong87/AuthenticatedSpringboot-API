package com.authenticator.authenticator.models;

import com.authenticator.authenticator.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    @JsonIgnoreProperties({"id", "password", "roles"})
    private User user;

    private String gender;
    private String status;
    private String city;
    private String state;

    public Profile(User user, String gender, String status, String city, String state) {
        this.user = user;
        this.gender = gender;
        this.status = status;
        this.city = city;
        this.state = state;
    }

    public Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
