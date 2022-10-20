package com.android.petopia.model;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String name;
    private String type;
    private String price;
    private String thumbnail;
    private String description;

    public Product() {
    }

    public Product(int id, String name, String type, String price, String thumbnail, String description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.price = price;
        this.thumbnail = thumbnail;
        this.description = description;
    }

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
