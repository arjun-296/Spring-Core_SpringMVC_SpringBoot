package com.niit.Rest_mongo_Product;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.Rest_mongo_Product.controller.ProductController;
import com.niit.Rest_mongo_Product.exception.ProductAlreadyExistsException;
import com.niit.Rest_mongo_Product.model.Product;
import com.niit.Rest_mongo_Product.model.ProductDescription;
import com.niit.Rest_mongo_Product.repository.ProductRepo;
import com.niit.Rest_mongo_Product.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(MockitoExtension.class)
public class NewProductControllerTest {


    @Mock          //dependency
    private ProductService service;

    @InjectMocks  //dependent
    private ProductController productController;

    @Autowired
    private MockMvc mockMvc;

    //reference creation
    private Product product;
    private ProductDescription productDescription;

    @BeforeEach
    public void PreTest(){

         productDescription = new ProductDescription("Air Filter", "K&N", "90",
                "Available", 201, 4589.87);
        product=new Product("Z001", "K&N Air Filter",productDescription);

        mockMvc= MockMvcBuilders.standaloneSetup(productController).build();
    }

    @AfterEach
    public void postTest(){

        product=null;
        productDescription=null;

    }

    public String convertToJson (final Object obj) throws JsonProcessingException {
        String result = "";

        try {
            ObjectMapper mapper = new ObjectMapper();
            result = mapper.writeValueAsString(obj);

        }
        catch(JsonProcessingException ex)
        {
            ex.printStackTrace();
        }


        return result;
    }




    @Test
    public void TestingAddProudctMethod() throws Exception {
        when(service.addProduct(any())).thenReturn(any());
        mockMvc.perform(post("/Prod").contentType(MediaType.APPLICATION_JSON)
                .content(convertToJson(product)))
                .andExpect(status().isAccepted()).andDo(MockMvcResultHandlers.print());
        verify(service,times(1)).addProduct(any());


    }

}
