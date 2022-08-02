package com.springCourse.springBootcamp.Product.Dto;

import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import lombok.Data;


import java.util.Date;

@Data
public class ProductDto {

    private Long Id;
    private Seller seller;
    private Buyer buyer;
    private String title;
    private String longText;
    private String shortText;
    private Date insDate;
    private Date updDate;
    private double displayPrice;
    private double discountPrice;
    private Boolean isDeleted;

}
