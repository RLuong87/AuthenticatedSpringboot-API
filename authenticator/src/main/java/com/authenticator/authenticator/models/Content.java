package com.authenticator.authenticator.models;

import com.authenticator.authenticator.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userContent;

//    @OneToOne
//    @JoinColumn(name = "id", referencedColumnName = "id")
//    @JsonIgnoreProperties({"id", "password", "roles"})
//    private User user;

//    public Content(String userContent, User user) {
//        this.userContent = userContent;
//        this.user = user;
//    }

    public Content() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserContent() {
        return userContent;
    }

    public void setUserContent(String userContent) {
        this.userContent = userContent;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
