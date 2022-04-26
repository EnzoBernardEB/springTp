package com.example.tp1.service;

import com.example.tp1.exception.ResourceNotFoundException;
import com.example.tp1.exception.StockException;
import com.example.tp1.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("products")
public class ProductServiceImpl implements ProductService{
    private final List<Product> allProducts = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return this.allProducts;
    }

    @Override
    public Product getProductById(Long id) {
        Product result = this.getAllProducts().stream().filter(product -> product.getId() == id).findFirst().get();
        if(result != null) {
            return result;
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public Product save(Product product) {
        this.allProducts.add(product);
        return product;
    }

    @Override
    public boolean isProductAvailable(Product product, int quantity) {
        return false;
    }

    @Override
    public void removeProduct(Product productToRemove, int quantity) throws StockException {
        Product targetProduct = this.getAllProducts().stream().filter(product -> product.getId() == productToRemove.getId()).findFirst().get();
        int newQuantity =targetProduct.getQuantity() - quantity;
        if(newQuantity<0) {
            throw new StockException("Pas de stock wesh");
        } else {
            targetProduct.setQuantity(newQuantity);
        }
    }
}
