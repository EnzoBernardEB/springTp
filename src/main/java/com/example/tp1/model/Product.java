package com.example.tp1.model;

public class Product {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String picture;
    private Integer quantity;

    public Product() {
        super();
    }

    public Product(Long id, String name, String description, Double price, String picture, Integer quantity) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.picture = picture;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", price=" + this.price
                + ", picture=" + this.picture + ", quantity=" + this.quantity + "]";
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }
}
