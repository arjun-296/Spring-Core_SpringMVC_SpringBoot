package com.niit.Rest_mongo_Product;

import com.niit.Rest_mongo_Product.model.Product;
import com.niit.Rest_mongo_Product.model.ProductDescription;
import com.niit.Rest_mongo_Product.repository.ProductRepo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataMongoTest
public class NewProductRepositoryTest {

    @Autowired
    private ProductRepo productRepo;

    //reference creation
    private Product product;
    private ProductDescription productDescription;

    @BeforeEach
    public void PreTest(){

        productDescription=new ProductDescription("Air Filter","K&N","90",
                "Available",201,4589.87);
        product=new Product("Z001", "K&N Air Filter",productDescription);
    }

    @AfterEach
    public void postTest(){

        product=null;
        productDescription=null;
        productRepo.deleteAll();

    }

    @Test
    public void testProductCode(){
        productRepo.insert(product);
        Product result=productRepo.findById(product.getProductCode()).get();
        assertNotNull(result);
        //comparing expected and actual attribute values
        assertEquals(result.getProductCode(),product.getProductCode());

    }
    @Test
    public void testProductName(){
        productRepo.insert(product);
        Product result=productRepo.findById(product.getProductCode()).get();
        assertNotNull(result);
        //comparing expected and actual attribute values
        assertEquals(result.getProductName(),product.getProductName());

    }
    @Test
    public void testProductStock(){
        productRepo.insert(product);
        Product result=productRepo.findById(product.getProductCode()).get();
        assertNotNull(result);
        //comparing expected and actual attribute values
        assertEquals(result.getProductDescription().getProductStock(),
                product.getProductDescription().getProductStock());

    }
    @Test
    public void testBrandName(){
        productRepo.insert(product);
        Product result=productRepo.findById(product.getProductCode()).get();
        assertNotNull(result);
        //comparing expected and actual attribute values
        assertEquals(result.getProductDescription().getProductBrand(),
                product.getProductDescription().getProductBrand());

    }


    @Test
    public void testingDelete(){

        productRepo.insert(product);
        productRepo.deleteById(product.getProductCode());
        assertEquals(Optional.empty(),productRepo.findById(product.getProductCode()));


    }

    @Test
    public void NegationTestUpdateProductName(){

        productRepo.insert(product); // has old data
        Product p= productRepo.findById(product.getProductCode()).get();
        p.setProductName("K and N Filter");
        productRepo.save(p);
        assertNotEquals(product.getProductName(), productRepo.findById(product.getProductCode()).get().getProductName());

    }

    @Test
    public void NegationTestUpdateProductBrand(){

        productRepo.insert(product); // has old data
        Product p= productRepo.findById(product.getProductCode()).get();
        p.getProductDescription().setProductBrand("K And N");
        productRepo.save(p);
        assertNotEquals(product.getProductDescription().getProductBrand(),
                productRepo.findById(product.getProductCode()).get().getProductDescription().getProductBrand());

    }

    @Test
    public void NegationTestUpdateProductPrice(){

        productRepo.insert(product);
        Product nP=productRepo.findById(product.getProductCode()).get();
        nP.getProductDescription().setProductPrice(2432.23);
        productRepo.save(nP);
        assertNotEquals(product.getProductDescription().getProductPrice(),nP.getProductDescription().getProductPrice());

    }

    @Test
    public void NegationTestUpdateProductStock(){

        productRepo.insert(product);
        Product p= productRepo.findById(product.getProductCode()).get();
        p.getProductDescription().setProductStock("");

        assertNotEquals(product.getProductDescription().getProductStock(),p.getProductDescription().getProductStock());

    }

//    @Test
//    public void NegationTestInsertObject(){
//
//        productRepo.insert(product);
//        Product result=productRepo.findById(product.getProductCode()).get();
//        assertNotNull(result);
//        //comparing expected and actual attribute values
//        assertNotEquals(Optional.empty().get(),product.getProductCode());
//
//
//
//    }
}
