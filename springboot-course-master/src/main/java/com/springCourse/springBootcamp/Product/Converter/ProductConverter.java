package com.springCourse.springBootcamp.Product.Converter;

import com.springCourse.springBootcamp.Product.Dto.ProductDto;
import com.springCourse.springBootcamp.Product.Entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public Product convertFromDto(ProductDto productDto) {
        Product product = new Product();

        product.setId(product.getId());
        product.setBuyer(product.getBuyer());
        product.setSeller(product.getSeller());
        product.setDiscountPrice(product.getDiscountPrice());
        product.setDisplayPrice(product.getDisplayPrice());
        product.setTitle(product.getTitle());
        product.setInsDate(product.getInsDate());
        product.setUpdDate(product.getUpdDate());
        product.setLongText(product.getLongText());
        product.setShortText(product.getShortText());
        product.setIsDeleted(product.getIsDeleted());

        return product;
    }
}
