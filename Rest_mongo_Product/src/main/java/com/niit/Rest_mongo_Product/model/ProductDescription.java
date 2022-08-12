package com.niit.Rest_mongo_Product.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDescription {

    private String productCategory;
    private String productBrand;
    private String productQuantity;
    private String productStock;
    private int productWeight;
    private double productPrice;


}
