package com.springCourse.springBootcamp.Product.Service;

import com.springCourse.springBootcamp.Product.Converter.ProductConverter;
import com.springCourse.springBootcamp.Product.Dao.ProductDao;
import com.springCourse.springBootcamp.Product.Dto.ProductDto;
import com.springCourse.springBootcamp.Product.Entity.Product;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import com.springCourse.springBootcamp.User.Enum.ProductApproval;
import com.springCourse.springBootcamp.User.Enum.SellerStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    public Product createNewFromDto(ProductDto productDto) {
        Product product = productConverter.convertFromDto(productDto);
        productDao.save(product);
        return product;
    }

    public Product isNewProduct(Product product) {
        List<String> productApprovalList = List.of(Arrays.toString(ProductApproval.class.getEnumConstants()));
        ProductApproval productApproval = product.getProductApproval();
        return productApprovalList.contains(productApproval.toString()) ? product : null;
    }


    public void updateStatus(ProductApproval productApproval) {
        productDao.setUpdateStatus(SellerStatus.valueOf("Active"), "waitingForApproval");
    }
}