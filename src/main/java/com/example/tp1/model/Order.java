package com.example.tp1.model;

import java.time.LocalDate;
import java.util.List;

public class Order {

    private Long id;
    private LocalDate dateCreated;
    private String status;
    private Client client;
    private List<OrderProduct> orderProducts;

    public Order() {
        super();
    }

    public Order(Long id, LocalDate dateCreated, String status, Client client, List<OrderProduct> orderProducts) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.status = status;
        this.client = client;
        this.orderProducts = orderProducts;
    }

    public Client getClient() {
        return this.client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Long getId() {
        return this.id;
    }

    public LocalDate getDateCreated() {
        return this.dateCreated;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderProduct> getOrderProducts() {
        return this.orderProducts;
    }

    @Override
    public String toString() {
        return "Order [id=" + this.id + ", dateCreated=" + this.dateCreated + ", status=" + this.status + ", client=" + this.client
                + ", orderProducts=" + this.orderProducts + "]";
    }

    public Double getTotalOrderPrice() {
        double sum = 0D;
        for (OrderProduct op : this.orderProducts) {
            sum += op.getTotalPrice();
        }
        return sum;
    }

    public int getNumberOfProducts() {
        return this.orderProducts.size();
    }

    public int getTotalNumberOfProducts() {
        int sum = 0;
        for (OrderProduct op : this.orderProducts) {
            sum += op.getQuantity();
        }
        return sum;
    }

    public void addProduct(Product product, int quantity) {
        OrderProduct orderProduct = null;

        // On regarde si le produit est déjà dans la commande, dans ce cas on ajoute seulement la quantité
        for (OrderProduct op: this.orderProducts) {
            if (op.getProduct().equals(product)) {
                orderProduct = op;
                orderProduct.setQuantity(op.getQuantity() + quantity);
                break;
            }
        }

        // Sinon on ajoute une nouvelle ligne de commande
        if (orderProduct == null) {
            orderProduct = new OrderProduct(this, product, quantity);
            this.orderProducts.add(orderProduct);
        }
    }

}
