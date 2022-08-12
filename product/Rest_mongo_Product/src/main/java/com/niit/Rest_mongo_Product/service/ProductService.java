package com.niit.Rest_mongo_Product.service;

import com.niit.Rest_mongo_Product.exception.ProductAlreadyExistsException;
import com.niit.Rest_mongo_Product.exception.ProductNotFoundException;
import com.niit.Rest_mongo_Product.model.Product;

import java.util.List;

public interface ProductService {
    public abstract List<Product> getAllProducts();
    public abstract Product addProduct(Product product) throws ProductAlreadyExistsException;
    public abstract boolean deleteProductDetails(String productCode) throws ProductNotFoundException;
    public abstract Product getProductById(String productCode) throws ProductNotFoundException;
    public abstract Product updateProductDetails(Product product);

}
