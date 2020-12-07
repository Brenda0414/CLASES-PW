/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 * Modelo de Tarjetas 
 * Esto es un POJO Plain Old Java Object
 * @author Stefania Cavazos
 */
public class Card {
    private String urlImage;
    private String title;
    private String description;
    private String linkRef;

    public Card() {
    }

    public Card(String urlImage, String title, String description, String linkRef) {
        this.urlImage = urlImage;
        this.title = title;
        this.description = description;
        this.linkRef = linkRef;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
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

    public String getLinkRef() {
        return linkRef;
    }

    public void setLinkRef(String linkRef) {
        this.linkRef = linkRef;
    }
    
    
    
}
