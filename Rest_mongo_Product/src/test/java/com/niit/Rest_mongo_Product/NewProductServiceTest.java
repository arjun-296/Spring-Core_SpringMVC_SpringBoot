package com.niit.Rest_mongo_Product;

import com.niit.Rest_mongo_Product.exception.ProductAlreadyExistsException;
import com.niit.Rest_mongo_Product.exception.ProductNotFoundException;
import com.niit.Rest_mongo_Product.model.Product;
import com.niit.Rest_mongo_Product.model.ProductDescription;
import com.niit.Rest_mongo_Product.repository.ProductRepo;
import com.niit.Rest_mongo_Product.service.ProductServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class NewProductServiceTest {

    @Mock
    private ProductRepo productRepo;

    @InjectMocks
    private ProductServiceImpl productServiceimpl;


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

    }



        @Test
        public void givenAddProductReturnProduct() throws ProductAlreadyExistsException,Exception{
        when(productRepo.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
        when(productRepo.save(product)).thenReturn(product);
        assertEquals(product,productServiceimpl.addProduct(product));
        verify(productRepo,times(1)).findById(product.getProductCode());
        verify(productRepo,times(1)).save(product);

        }

        @Test
        public void givenProductToSaveReturnProductFaliure() throws ProductAlreadyExistsException {
        when(productRepo.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
        assertThrows(ProductAlreadyExistsException.class,()->productServiceimpl.addProduct(product));
        verify(productRepo,times(1)).findById(product.getProductCode());
        verify(productRepo,times(0)).save(product);
    }

        @Test
         public void ProductDelete() throws ProductNotFoundException{
        when(productRepo.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
        boolean result = productServiceimpl.deleteProductDetails(product.getProductCode());
        assertTrue(result);
        verify(productRepo,times(1)).findById(product.getProductCode());
        verify(productRepo,times(1)).deleteById(product.getProductCode());

    }
         @Test
         public void ProductDeleteFaliure()throws ProductNotFoundException{
        when(productRepo.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
        assertThrows(ProductNotFoundException.class, ()->productServiceimpl.deleteProductDetails(product.getProductCode()));
        verify(productRepo,times(1)).findById(product.getProductCode());
        verify(productRepo,times(0)).deleteById(product.getProductCode());

    }

         @Test
         public void ProductFindByProductCode() throws ProductNotFoundException {
        when(productRepo.findById(product.getProductCode())).thenReturn(Optional.ofNullable(product));
            assertEquals(product,productServiceimpl.getProductById(product.getProductCode()));
        }

        @Test
        public void ProductFindByProductCodeFaliure() throws ProductNotFoundException{
        when(productRepo.findById(product.getProductCode())).thenReturn(Optional.ofNullable(null));
        assertThrows(ProductNotFoundException.class, ()->productServiceimpl.getProductById(product.getProductCode()));
        assertNotEquals(null,product);
        verify(productRepo,times(1)).findById(product.getProductCode());
        }

}
