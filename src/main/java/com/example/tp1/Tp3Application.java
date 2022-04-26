package com.example.tp1;

import com.example.tp1.exception.StockException;
import com.example.tp1.model.Client;
import com.example.tp1.model.Order;
import com.example.tp1.model.OrderProduct;
import com.example.tp1.model.Product;
import com.example.tp1.service.OrderService;
import com.example.tp1.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.util.ArrayList;

@ComponentScan("com.*")
public class Tp3Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Tp3Application.class);

        ProductService productService = context.getBean("products", ProductService.class);
        OrderService orderService = context.getBean("orders", OrderService.class);

        Product product1 = new Product(1l, "Produit 1", "desc du prod 1", 12d, "url1", 1);
        Product product2 = new Product(2l, "Produit 2", "desc du prod 2", 32d, "url2", 4);
        Product product3 = new Product(3l, "Produit 3", "desc du prod 3", 22d, "url3", 54);

        productService.save(product1);
        productService.save(product2);
        productService.save(product3);
        productService.getAllProducts().stream().forEach(System.out::println);

        Client client = new Client(1l, "Peter", "1234");

        Order order = new Order(1l, LocalDate.now(), null, client, new

                ArrayList<OrderProduct>());

        order.addProduct(product1, 2);
        order.addProduct(product3, 4);
        System.out.println(order + "1");

        orderService.create(order);
        System.out.println(order + "2");
        try {
            orderService.update(order);
        } catch (StockException stockException) {
            System.out.println(stockException.getMessage());
        }
        System.out.println(order + "3");
    }

}
