package com.springCourse.springBootcamp.Basket.Dao;

import com.springCourse.springBootcamp.Basket.Entity.Basket;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketDao extends JpaRepository<Basket, Long> {
    @Query("select basket from Basket basket")
    List<Basket> findAll();

    @Query("select basket from Basket basket where basket.Id=:Id")
    Basket findAllById(@Param("Id") Long Id);

    @Query("select basket from Basket basket where basket.amount=:amount")
    Basket findAllByAmount(@Param("amount") int amount);

    @Query("select basket from Basket basket where basket.productName=:productName")
    Basket findAllByProductName(@Param("productName") String productName);

    @Query("select basket from Basket basket where basket.buyer=:buyer")
    Basket findAllByBuyer(@Param("buyer") Buyer buyer);

    @Query("select basket from Basket basket where basket.isEmpty=:isEmpty")
    Basket findAllByIsEmpty(@Param("isEmpty") boolean isEmpty);

    @Query("delete from Basket basket where basket.Id=:basketId")
    void deleteById(@Param("basketId") Long basketId);
}
