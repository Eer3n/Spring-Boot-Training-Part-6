package com.springCourse.springBootcamp.Basket.Controller;

import com.springCourse.springBootcamp.Basket.Dto.BasketDto;
import com.springCourse.springBootcamp.Basket.Entity.Basket;
import com.springCourse.springBootcamp.Basket.Exception.BasketNotFoundException;
import com.springCourse.springBootcamp.Basket.Service.BasketService;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/basket")
@RequiredArgsConstructor
public class BasketController {

    private final BasketService basketService;

    @GetMapping("/find-all")
    public List<Basket> findAllByBasketProducts() {
        return basketService.findAll();
    }

    @GetMapping("/{Id}")
    public Basket findAllById(@PathVariable Long Id) {
        return basketService.findAllById(Id);
    }

    @GetMapping("/create")
    public void save(@RequestBody BasketDto basketDto) {
        basketService.createNewFromDto(basketDto);
    }

    @GetMapping("/amount")
    public Basket findAllByAmount(@PathVariable int amount) {
        return basketService.findAllByAmount(amount);
    }

    @GetMapping("/{productName}")
    public Basket findAllByProductName(@PathVariable String productName) throws Exception {
        Basket basket = basketService.findAllByProductName(productName);
        if (productName == null) {
            throw new BasketNotFoundException("Basket is empty!");
        }
        return basket;
    }

    @GetMapping("/buyer")
    public Basket findAllByBuyer(@PathVariable Buyer buyer) {
        return basketService.findAllByBuyer(buyer);
    }

    @GetMapping("/isEmpty")
    public void isEmpty(@PathVariable Boolean isEmpty) {
        basketService.findAllByIsEmpty(isEmpty);
    }

    @PostMapping("/addNewItem")
    public void save(@RequestBody Basket basket) {
        basketService.addNewItem(basket);
    }

    @PostMapping("/delete")
    public void delete(@RequestBody Basket basket) {
        basketService.deleteSelectedItem(basket);
    }

    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public Basket update(@RequestBody BasketDto basketDto) {
        Basket basket = basketService.createNewFromDto(basketDto);
        if (basket == null) {
            throw new BasketNotFoundException("basket not found");
        }
        return basketService.update(basket);
    }
}
