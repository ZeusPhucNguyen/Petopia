package com.android.petopia.model;

import java.io.Serializable;

public class Service implements Serializable {
    private int id;
    private String nameLocation;
    private String address;
    private String phone;
    private String email;
    private String description;
    private String thumbnail;

    public Service(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLocation() {
        return nameLocation;
    }

    public void setNameLocation(String nameLocation) {
        this.nameLocation = nameLocation;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Service(int id, String nameLocation, String address, String phone, String email, String description, String thumbnail) {
        this.id = id;
        this.nameLocation = nameLocation;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.description = description;
        this.thumbnail = thumbnail;
    }




}
