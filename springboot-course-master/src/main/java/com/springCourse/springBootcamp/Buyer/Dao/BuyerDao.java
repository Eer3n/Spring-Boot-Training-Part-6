package com.springCourse.springBootcamp.Buyer.Dao;

import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyerDao extends JpaRepository<Buyer, Long> {
    @Query("select buyer from Buyer buyer")
    List<Buyer> findAll();

    @Query("select buyer from Buyer buyer where buyer.Id =:Id")
    Buyer findAllById(@Param("Id") Long Id);

    @Query("select buyer from Buyer buyer where buyer.username =:buyerUserName and buyer.password =:buyerPassword")
    Buyer findAllByUsernameAndPassword(@Param("buyerUserName") String username, @Param("buyerPassword") String password);

    List<Buyer> findByIsBanned(Boolean isBanned);

    Buyer save(Buyer buyer);

    @Query("delete from Buyer buyer where buyer.Id=:buyerId")
    void deleteAllById(@Param("buyerId") Long Id);
}
