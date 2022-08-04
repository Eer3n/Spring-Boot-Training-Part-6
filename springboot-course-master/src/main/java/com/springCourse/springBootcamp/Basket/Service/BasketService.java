package com.springCourse.springBootcamp.Basket.Service;

import com.springCourse.springBootcamp.Basket.Converter.BasketConverter;
import com.springCourse.springBootcamp.Basket.Dao.BasketDao;
import com.springCourse.springBootcamp.Basket.Dto.BasketDto;
import com.springCourse.springBootcamp.Basket.Entity.Basket;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Product.Entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BasketService {

    private final BasketDao basketDao;

    private final BasketConverter basketConverter;

    public List<Basket> findAll() {
        return basketDao.findAll();
    }

    public Basket findAllById(Long Id) {
        return basketDao.findAllById(Id);
    }

    public Basket findAllByAmount(int amount) {
        return basketDao.findAllByAmount(amount);
    }

    public Basket findAllByProductName(String productName) {
        return basketDao.findAllByProductName(productName);
    }

    public Basket findAllByBuyer(Buyer buyer) {
        return basketDao.findAllByBuyer(buyer);
    }

    public Basket findAllByIsEmpty(boolean isEmpty) {
        return basketDao.findAllByIsEmpty(isEmpty);
    }

    public Basket addNewItem(Basket basket) {
        return basketDao.save(basket);
    }

    public List<Basket> findAllByProduct(Product product) {
        return findAllByProduct(product);
    }

    public void deleteSelectedItem(Basket basket) {
        basketDao.delete(basket);
    }

    public Basket createNewFromDto(BasketDto basketDto) {
        Basket basket = basketConverter.convertFromDto(basketDto);
        basketDao.save(basket);
        return basket;
    }

    public Basket update(Basket basket) {
        return basketDao.save(basket);
    }
}
