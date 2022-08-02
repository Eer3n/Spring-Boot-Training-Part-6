package com.springCourse.springBootcamp.Seller.Controller;

import com.springCourse.springBootcamp.Seller.Entity.Seller;
import com.springCourse.springBootcamp.Seller.Service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("api/v1/seller")
@RequiredArgsConstructor
public class SellerController {

    private final SellerService sellerService;

    @GetMapping("/find-all")
    public List<Seller> findAllSellers() {
        return sellerService.findAll();
    }

    @GetMapping("/{Id}")
    public Seller findSellerById(@PathVariable Long Id) {
        return sellerService.findAllById(Id);
    }

    @GetMapping("/{username}/{password}")
    public Seller findByUsernameAndPassword(@PathVariable String username, @PathVariable String password) {
        return sellerService.findAllByUsernameAndPassword(username, password);
    }

}
