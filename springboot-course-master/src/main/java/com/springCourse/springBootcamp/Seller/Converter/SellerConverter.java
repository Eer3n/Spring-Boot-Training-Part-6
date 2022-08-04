package com.springCourse.springBootcamp.Seller.Converter;

import com.springCourse.springBootcamp.Seller.Dto.SellerDto;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import org.springframework.stereotype.Component;

@Component
public class SellerConverter {
    public Seller convertFromDto(SellerDto sellerDto) {
        Seller seller = new Seller();

        seller.setId(seller.getId());
        seller.setUsername(seller.getUsername());
        seller.setMailAddress(seller.getMailAddress());
        seller.setPassword(seller.getPassword());
        seller.setStoreName(seller.getStoreName());
        seller.setTotalProducts(seller.getTotalProducts());
        seller.setTotalScore(seller.getTotalScore());
        seller.setCountriesThatSells(seller.getCountriesThatSells());
        seller.setUserStatus(seller.getUserStatus());

        return seller;
    }
}
