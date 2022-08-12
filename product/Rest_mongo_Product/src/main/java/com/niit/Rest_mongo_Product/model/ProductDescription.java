package com.niit.Rest_mongo_Product.model;

public class ProductDescription {

    private String productCategory;
    private String productBrand;
    private String productQuantity;
    private String productStock;
    private int productWeight;
    private double productPrice;

    public ProductDescription(String productCategory, String productBrand,
                              String productQuantity, String productStock,
                              int productWeight, double productPrice) {
        this.productCategory = productCategory;
        this.productBrand = productBrand;
        this.productQuantity = productQuantity;
        this.productStock = productStock;
        this.productWeight = productWeight;
        this.productPrice = productPrice;
    }

    public ProductDescription() {
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductBrand() {
        return productBrand;
    }

    public void setProductBrand(String productBrand) {
        this.productBrand = productBrand;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductStock() {
        return productStock;
    }

    public void setProductStock(String productStock) {
        this.productStock = productStock;
    }

    public int getProductWeight() {
        return productWeight;
    }

    public void setProductWeight(int productWeight) {
        this.productWeight = productWeight;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "ProductDescription{" +
                "productCategory='" + productCategory + '\'' +
                ", productBrand='" + productBrand + '\'' +
                ", productQuantity='" + productQuantity + '\'' +
                ", productStock='" + productStock + '\'' +
                ", productWeight=" + productWeight +
                ", productPrice=" + productPrice +
                '}';
    }
}
