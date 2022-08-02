package com.springCourse.springBootcamp.Product.Controller;

import com.springCourse.springBootcamp.Product.Entity.Product;
import com.springCourse.springBootcamp.Product.Exception.ProductNotFoundException;
import com.springCourse.springBootcamp.Product.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/find-all")
    public List<Product> findAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{Id}")
    public Product findProductById(@PathVariable Long Id) {
        return productService.findAllById(Id);
    }

    @GetMapping("/{title}")
    public Product findProductByTitle(@PathVariable String title) throws Exception {
        Product product = productService.findAllByTitle(title);
        if (product == null) {
            throw new ProductNotFoundException("product not found");
        }
        return product;
    }

    @PostMapping("/create")
    public void save(@RequestBody Product product) {
        productService.createNewProduct(product);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Product product) {
        productService.deleteGivenProduct(product);
    }
}