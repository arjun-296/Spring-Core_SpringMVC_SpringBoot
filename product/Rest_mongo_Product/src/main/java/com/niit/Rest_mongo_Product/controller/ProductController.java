package com.niit.Rest_mongo_Product.controller;

import com.niit.Rest_mongo_Product.exception.ProductAlreadyExistsException;
import com.niit.Rest_mongo_Product.exception.ProductNotFoundException;
import com.niit.Rest_mongo_Product.model.Product;
import com.niit.Rest_mongo_Product.service.ProductService;
import com.niit.Rest_mongo_Product.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productApp/v9")
public class ProductController {

    ProductService imp;

    @Autowired
    public ProductController(ProductService imp) {
        this.imp=imp;

    }

    //ListAll
    //->http://localhost:5656/productApp/v9/
    @GetMapping("/")
    public ResponseEntity<?> ShowAllProd(){
        return new ResponseEntity<>(imp.getAllProducts(), HttpStatus.OK);
    }

    //AddProduct
    //->http://localhost:5656/productApp/v9/Prod
    @PostMapping("/Prod")
    public ResponseEntity<?> AddProd(@RequestBody Product product) throws ProductAlreadyExistsException {

        try{
            return new ResponseEntity<>(imp.addProduct(product), HttpStatus.ACCEPTED);
        }
        catch(ProductAlreadyExistsException pe){
            throw new ProductAlreadyExistsException();
        }

    }

    //FindByProductCode
    //->http://localhost:5656/productApp/v9/get-by-code/{productCode}
    @GetMapping("/get-by-code/{productCode}")
    public ResponseEntity<?> filterByCode(@PathVariable String productCode) throws ProductNotFoundException
    {
        try{

            return new ResponseEntity<>(imp.getProductById(productCode), HttpStatus.FOUND);
        }
        catch(ProductNotFoundException ex){
            throw new ProductNotFoundException();

        }
    }

    //DeleteByCode
    //->http://localhost:5656/productApp/v9/del-by-code/{productCode}
    @DeleteMapping("/del-by-code/{productCode}")
    public ResponseEntity<?> RemoveByCode(@PathVariable String productCode) throws ProductNotFoundException{

        try{
            imp.deleteProductDetails(productCode);
            return new ResponseEntity<>("Product Deleted", HttpStatus.OK);
        }
        catch(ProductNotFoundException pf){

            throw new ProductNotFoundException();
        }
    }

    //Update
    //->http://localhost:5656/productApp/v9/updateProd
    @PostMapping("/updateProd")
    public ResponseEntity<?> update(@RequestBody Product product)  {

            return new ResponseEntity<>(imp.updateProductDetails(product), HttpStatus.ACCEPTED);

    }



}
