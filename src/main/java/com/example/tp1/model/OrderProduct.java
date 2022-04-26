package com.example.tp1.model;

public class OrderProduct {

	private Product product;
	private Order order;
	private int quantity;

	public OrderProduct() {
		super();
	}

	public OrderProduct(Order order, Product product, int quantity) {
		super();
		this.product = product;
		this.order = order;
		this.quantity = quantity;
	}

	public Order getOrder() {
		return this.order;
	}

	public Product getProduct() {
		return this.product;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderProduct [product=" + this.product + ", quantity=" + this.quantity + "]";
	}

	public Double getTotalPrice() {
		return getProduct().getPrice() * getQuantity();
	}

}
