package com.springCourse.springBootcamp.Basket.Converter;

import com.springCourse.springBootcamp.Basket.Dto.BasketDto;
import com.springCourse.springBootcamp.Basket.Entity.Basket;
import org.springframework.stereotype.Component;

@Component
public class BasketConverter {

    public Basket convertFromDto(BasketDto basketDto){
        Basket basket = new Basket();

        basket.setId(basket.getId());
        basket.setAmount(basket.getAmount());
        basket.setProductList(basket.getProductList());
        basket.setProductName(basket.getProductName());
        basket.setIsEmpty(basket.getIsEmpty());

        return basket;
    }
}
