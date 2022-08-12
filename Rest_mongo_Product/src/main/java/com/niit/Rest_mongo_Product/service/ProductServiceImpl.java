package com.niit.Rest_mongo_Product.service;

import com.niit.Rest_mongo_Product.exception.ProductAlreadyExistsException;
import com.niit.Rest_mongo_Product.exception.ProductNotFoundException;
import com.niit.Rest_mongo_Product.model.Product;
import com.niit.Rest_mongo_Product.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo rep;


    @Override
    public List<Product> getAllProducts() {
        return rep.findAll();
    }

    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistsException {
       if(rep.findById(product.getProductCode()).isEmpty()){
           return rep.save(product);
       }
       else{
           throw new ProductAlreadyExistsException();
       }

    }

    @Override
    public boolean deleteProductDetails(String productCode) throws ProductNotFoundException {
        if(rep.findById(productCode).isPresent()){
            rep.deleteById(productCode);
            return true;
        }
        else{
            throw new ProductNotFoundException();
        }
    }

    @Override
    public Product getProductById(String productCode) throws ProductNotFoundException {

       if(rep.findById(productCode).isPresent()){
           return rep.findById(productCode).get();
       }
       else{
           throw new ProductNotFoundException();
       }
    }

    @Override
    public Product updateProductDetails(Product product) {
        return rep.save(product);
    }
}
