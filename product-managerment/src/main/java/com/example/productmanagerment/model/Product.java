package com.example.productmanagerment.model;

public class Product {
    private int id;
    private String idProduct;
    private String name;
    private long price;
    private String producer;
    private String note;

    public Product() {
    }

    public Product(int id, String idProduct, String name, long price, String producer, String note) {
        this.id = id;
        this.idProduct = idProduct;
        this.name = name;
        this.price = price;
        this.producer = producer;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}