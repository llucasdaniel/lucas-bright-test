package com.lucas.bright.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Lucas Daniel
 */
@JacksonXmlRootElement(localName = "realm")
@Entity
@Table(name = "user_realm")
public class User implements Serializable {

    @Id // Unique and  nullable = false
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JacksonXmlProperty(isAttribute = true)
    private int id;

    //name is unique, not nullable and 50 length
    @Column(unique = true, length = 50, nullable = false)
    @NotEmpty
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    //size of description
    @Column(length = 255)
    private String description;

    //key is not nullable and 32 length
    // "name" is just to differ from what the JSON/XML returns to the database
    @Column(name = "key_password", length = 32, nullable = false)
    private String key;

    public User(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public User() {
    }

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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}
