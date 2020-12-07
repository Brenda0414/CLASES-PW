/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pw.pw02semana11.models;

/**
 *
 * @author magoc
 */
public class News {

    private int id;
    private String title;
    private String description;
    private String pathImage;
    // has-a
    private Category category;

    public News() {
    }

    public News(int id) {
        this.id = id;
    }

    public News(String title, String description, String pathImage, Category category) {
        this.title = title;
        this.description = description;
        this.pathImage = pathImage;
        this.category = category;
    }

    public News(int id, String title, String description, String pathImage, Category category) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.pathImage = pathImage;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPathImage() {
        return pathImage;
    }

    public void setPathImage(String pathImage) {
        this.pathImage = pathImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
