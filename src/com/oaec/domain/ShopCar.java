package com.oaec.domain;

public class ShopCar {
    private int pid;
    private int pnum;
    private String uid;
    private String name;
    private String description;
    private double price;
    private int stock;
    private int majorId;
    private int minorId;
    private String imgSource;

    @Override
    public String toString() {
        return "ShopCar{" +
                "pid=" + pid +
                ", pnum=" + pnum +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", majorId=" + majorId +
                ", minorId=" + minorId +
                ", imgSource='" + imgSource + '\'' +
                '}';
    }

    public ShopCar(int pid, int pnum, String uid, String name, String description, double price, int stock, int majorId, int minorId, String imgSource) {
        this.pid = pid;
        this.pnum = pnum;
        this.uid = uid;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.majorId = majorId;
        this.minorId = minorId;
        this.imgSource = imgSource;
    }

    public ShopCar() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMajorId() {
        return majorId;
    }

    public void setMajorId(int majorId) {
        this.majorId = majorId;
    }

    public int getMinorId() {
        return minorId;
    }

    public void setMinorId(int minorId) {
        this.minorId = minorId;
    }

    public String getImgSource() {
        return imgSource;
    }

    public void setImgSource(String imgSource) {
        this.imgSource = imgSource;
    }
}
