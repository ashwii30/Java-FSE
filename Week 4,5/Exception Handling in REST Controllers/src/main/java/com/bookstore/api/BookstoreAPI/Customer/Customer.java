package com.bookstore.api.BookstoreAPI.Customer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Long getid(){
        return id;
    }

    public String getname(){
        return name;
    }
    public String getemail(){
        return email;
    }
    public String getphone(){
        return phone;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setEmail(String email) {
        this.email=email;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
}
