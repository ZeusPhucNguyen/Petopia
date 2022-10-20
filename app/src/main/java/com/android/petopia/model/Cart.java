package com.android.petopia.model;
public class Cart {
    private String proName;
    private String proPrice;
    private String qty;
    private String total;
    private String proType;
    private String proThumbnail;

    public Cart() {

    }

    public Cart(String proName, String proPrice, String qty, String total, String proType, String proThumbnail) {
        this.proName = proName;
        this.proPrice = proPrice;
        this.qty = qty;
        this.total = total;
        this.proType = proType;
        this.proThumbnail = proThumbnail;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPrice() {
        return proPrice;
    }

    public void setProPrice(String proPrice) {
        this.proPrice = proPrice;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProType() {
        return proType;
    }

    public void setProType(String proType) {
        this.proType = proType;
    }

    public String getProThumbnail() {
        return proThumbnail;
    }

    public void setProThumbnail(String proThumbnail) {
        this.proThumbnail = proThumbnail;
    }
}
