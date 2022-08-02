package com.springCourse.springBootcamp.Product.Service;

import com.springCourse.springBootcamp.Product.Converter.ProductConverter;
import com.springCourse.springBootcamp.Product.Dao.ProductDao;
import com.springCourse.springBootcamp.Product.Dto.ProductDto;
import com.springCourse.springBootcamp.Product.Entity.Product;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductDao productDao;

    private final ProductConverter productConverter;

    public List<Product> findAll() {
        return productDao.findAll();
    }

    public Product findAllById(Long Id) {
        return productDao.findAllById(Id);
    }

    public Product findAllByTitle(String title) {
        return productDao.findAllByTitle(title);
    }

    public List<Product> findAllBySeller(Seller seller) {
        return findAllBySeller(seller);
    }

    public Product createNewProduct(Product product) {
        return productDao.save(product);
    }

    public void deleteGivenProduct(Product product) {
        productDao.delete(product);
    }

    public Product createNewFromDto(ProductDto productDto){
        Product product = productConverter.convertFromDto(productDto);
        productDao.save(product);
        return product;
    }

   }