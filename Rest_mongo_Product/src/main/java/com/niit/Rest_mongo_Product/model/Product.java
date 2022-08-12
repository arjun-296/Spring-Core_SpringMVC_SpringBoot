package com.niit.Rest_mongo_Product.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document
@JsonPropertyOrder({"Desc","Code","Name"})
public class Product {

    @Id
    @JsonProperty(value="Code", access= JsonProperty.Access.READ_WRITE)
    private String productCode;

    @JsonProperty(value="Name", access= JsonProperty.Access.READ_WRITE)
    private String productName;

    @JsonProperty(value="Desc", access= JsonProperty.Access.READ_WRITE)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ProductDescription productDescription;


}
