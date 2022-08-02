package com.springCourse.springBootcamp.Seller.Dto;

import com.springCourse.springBootcamp.User.Enum.Countries;
import com.springCourse.springBootcamp.User.Enum.UserStatus;
import lombok.Data;

@Data
public class SellerDto {

    private Long Id;
    private String username;
    private String mailAddress;
    private String password;
    private String storeName;
    private int totalProducts;
    private int totalScore;
    private Countries countriesThatSells;
    private UserStatus userStatus;

}
