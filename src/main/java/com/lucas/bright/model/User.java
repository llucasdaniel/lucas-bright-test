package com.lucas.bright.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Lucas Daniel
 */
@Entity
@Table(name = "user_realm")
public class User {

    @Id // Unique and  nullable = false
    private int id;
    
    //name is unique, not nullable and 50 length
    @Column(unique = true, length = 50, nullable = false)
    private String name;
    
    //size of description
    @Column(length = 255)
    private String description;
    
    //key is not nullable and 32 length
    // "name" is just to differ from what the JSON/XML returns to the database
    @Column(name = "key_password", length = 32, nullable = false)
    private String password;

    public User(int id) {
        this.id = id;
    }

    //getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
