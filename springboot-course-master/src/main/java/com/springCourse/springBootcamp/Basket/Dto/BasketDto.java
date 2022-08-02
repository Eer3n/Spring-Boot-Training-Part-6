package com.springCourse.springBootcamp.Basket.Dto;

import com.springCourse.springBootcamp.Product.Entity.Product;
import lombok.Data;

@Data
public class BasketDto {

    private Long Id;
    private Product product;
    private String productName;
    private int amount;
    private Boolean isEmpty;

}
