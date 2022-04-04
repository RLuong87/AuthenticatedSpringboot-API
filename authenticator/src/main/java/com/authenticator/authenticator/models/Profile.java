package com.authenticator.authenticator.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Profile {

    @Id
    @GeneratedValue
    private Long id;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
