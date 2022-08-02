package com.springCourse.springBootcamp.Seller.Dao;

import com.springCourse.springBootcamp.Seller.Entity.Seller;
import com.springCourse.springBootcamp.User.Enum.Countries;
import com.springCourse.springBootcamp.User.Enum.UserStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellerDao extends CrudRepository<Seller, Long> {
    @Query("select seller from Seller seller")
    List<Seller> findAll();

    @Query("select seller from Seller seller where seller.Id =:Id")
    Seller findAllById(@Param("Id") Long Id);

    @Query("select seller from Seller seller where seller.storeName=:storeName")
    Seller findAllByStoreName(@Param("storeName") String storeName);

    @Query("select seller from Seller seller where seller.countriesThatSells=:countriesThatSells")
    List<Seller> findAllByCountriesThatSells(@Param("countriesThatSells") Countries countriesThatSells);

    @Query("select seller from Seller seller where seller.userStatus=:userStatus")
    List<Seller> findAllByUserStatus(@Param("userStatus") UserStatus userStatus);

    @Query("select seller from Seller seller where seller.username=:username and seller.password=:password")
    Seller findAllByUsernameAndPassword(String username, String password);
}
