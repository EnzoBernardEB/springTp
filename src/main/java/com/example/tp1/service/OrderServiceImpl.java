package com.example.tp1.service;

import com.example.tp1.exception.StockException;
import com.example.tp1.model.Order;
import com.example.tp1.model.OrderProduct;
import com.example.tp1.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("orders")
public class OrderServiceImpl implements OrderService{
    private List<Order> allOrders = new ArrayList<Order>();
    @Autowired
    private ProductService productService;

    public ProductService getProductService() {
        return productService;
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public List<Order> getAllOrders() {

        return this.allOrders;
    }

    @Override
    public Order create(Order order) {
        order.setStatus("En cours");
        this.allOrders.add(order);
        return order;
    }

    @Override
    public void update(Order orderModify) throws StockException {
        Order orderToUpdate = this.allOrders.stream().filter(order -> Objects.equals(order.getId(), orderModify.getId())).findAny().get();

        List<OrderProduct> orderProductsList = orderToUpdate.getOrderProducts();

        if(!orderToUpdate.getStatus().equals("Payée")) {
            for (int i = 0; i < orderProductsList.size(); i++) {
                long productId = orderProductsList.get(i).getProduct().getId();
                Product productUpdate = productService.getProductById(productId);
                if(productUpdate.getQuantity() < orderProductsList.get(i).getQuantity()) {
                    throw new StockException("Pas assez de stock wesh");
                } else {
                    productUpdate.setQuantity(productUpdate.getQuantity() - orderProductsList.get(i).getQuantity());
                    productService.save(productUpdate);
                }
            }
            orderToUpdate = orderModify;
            orderToUpdate.setStatus("Payée");
        }

    }
}
