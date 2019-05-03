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
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author Lucas Daniel
 */
//annotation - Used for result name 
@JacksonXmlRootElement(localName = "realm")
@Entity
@Table(name = "user_realm") // table name to differ from the Class name
public class User implements Serializable {

    @Id // Unique and  nullable = false
    @GeneratedValue(strategy = GenerationType.IDENTITY) // generate the ID code
    @JacksonXmlProperty(isAttribute = true) // put the atribbute in the first line XML <realm id="1234" name="realmName">
    private int id;

    //name is unique, not nullable and 50 size
    @Column(unique = true, length = 50, nullable = false)
    @Length(max = 50) // Use to validate the max lenght - the user can not use more than 50 characters
    @NotEmpty
    @JacksonXmlProperty(isAttribute = true)
    private String name;

    //size of description
    @Column(length = 255)
    @Length(max = 255) // use for validation
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
