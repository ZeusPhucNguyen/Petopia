package com.android.petopia.model;

import java.io.Serializable;

public class Pet implements Serializable {
    private int id;
    private String name;
    private String age;
    private String breed;
    private String address;
    private String sex;
    private String thumbnail;
    private String image;
    private String description;
    private String type;

    public Pet() {

    }

    public Pet(int id, String name, String age, String breed, String address, String sex, String thumbnail, String image, String description, String type) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.breed = breed;
        this.address = address;
        this.sex = sex;
        this.thumbnail = thumbnail;
        this.image = image;
        this.description = description;
        this.type = type;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
