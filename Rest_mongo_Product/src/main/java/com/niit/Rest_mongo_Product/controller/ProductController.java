package com.niit.Rest_mongo_Product.controller;

import com.niit.Rest_mongo_Product.model.Product;
import com.niit.Rest_mongo_Product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService imp;


    //(http://localhost:9898/product/get)
    //ListAll
    @GetMapping("/get")
    public ResponseEntity<?> ShowAllProd(){
        return new ResponseEntity<>(imp.getAllProducts(), HttpStatus.OK);
    }

    //AddProduct
    //(http://localhost:9898/product/add)
    @PostMapping("/add")
    public ResponseEntity<?> AddProd(@RequestBody Product product) {
        return new ResponseEntity<>(imp.addProduct(product), HttpStatus.ACCEPTED);
    }

    //FindByProductCode
    //(http://localhost:9898/product/get/{productCode})
    @GetMapping("/get/{productCode}")
    public ResponseEntity<?> filterByCode(@PathVariable String productCode)
    {


            return new ResponseEntity<>(imp.getProductById(productCode), HttpStatus.FOUND);

    }

    //DeleteByCode
    //(http://localhost:9898/product/remove/{productCode})
    @DeleteMapping("/remove/{productCode}")
    public ResponseEntity<?> RemoveByCode(@PathVariable String productCode) {


            imp.deleteProductDetails(productCode);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);

    }

    //Update
    //(http://localhost:9898/product/update)
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Product product)  {

            return new ResponseEntity<>(imp.updateProductDetails(product), HttpStatus.ACCEPTED);

    }



}
