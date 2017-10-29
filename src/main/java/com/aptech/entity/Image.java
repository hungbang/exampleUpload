package com.aptech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by KAI on 10/28/17.
 */
@Entity
public class Image implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String path;

    public Image(){

    }

    public Image(String pathImage) {
        this.path = pathImage;
    }

    public Integer getId() {
        return id;
    }

    public Image setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getPath() {
        return path;
    }

    public Image setPath(String path) {
        this.path = path;
        return this;
    }
}
