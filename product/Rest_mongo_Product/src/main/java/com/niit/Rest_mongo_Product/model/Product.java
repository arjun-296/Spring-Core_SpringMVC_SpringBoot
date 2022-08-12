package com.niit.Rest_mongo_Product.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;

@Document
public class Product {

    @Id
    private String productCode;
    private String productName;
    private ProductDescription productDescription;

    public Product(String productCode, String productName, ProductDescription productDescription) {
        this.productCode = productCode;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Product() {
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public ProductDescription getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription=" + productDescription +
                '}';
    }
}
