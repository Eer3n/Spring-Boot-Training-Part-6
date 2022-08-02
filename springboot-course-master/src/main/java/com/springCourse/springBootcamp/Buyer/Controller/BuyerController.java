package com.springCourse.springBootcamp.Buyer.Controller;

import com.springCourse.springBootcamp.Buyer.Dto.BuyerDto;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Buyer.Exception.BuyerNotFoundException;
import com.springCourse.springBootcamp.Buyer.Service.BuyerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/buyer")
@RequiredArgsConstructor
public class BuyerController {

    private final BuyerService buyerService;

    @GetMapping("/find-all")
    public List<Buyer> findAllBuyers() {
        return buyerService.findAll();
    }

    @GetMapping("/find/{Id}")
    public Buyer findBuyerById(@PathVariable Long Id) {
        return buyerService.findAllById(Id);
    }

    @GetMapping("/{username}/{password}")
    public Buyer findByUsernameAndPassword(@PathVariable String username, @PathVariable String password) throws Exception {
        Buyer buyer = buyerService.findAllByUsernameAndPassword(username, password);
        if (buyer == null) {
            throw new BuyerNotFoundException("buyer not found");
        }
        return buyer;
    }

    @PostMapping("/create")
    public void save(@RequestBody BuyerDto buyerDto) {
        buyerService.createNewFromDto(buyerDto);
    }

    @PostMapping("/delete/by-id/{buyerId}")
    public void delete(@PathVariable Long buyerId) {
        buyerService.deleteById(buyerId);
    }

    @PostMapping("/delete/")
    public void delete(@RequestBody Buyer buyer) {
        buyerService.deleteGivenBuyer(buyer);
    }
}