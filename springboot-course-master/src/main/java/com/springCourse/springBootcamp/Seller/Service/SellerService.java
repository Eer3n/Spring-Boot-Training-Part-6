package com.springCourse.springBootcamp.Seller.Service;

import com.springCourse.springBootcamp.Seller.Dao.SellerDao;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import com.springCourse.springBootcamp.User.Enum.Countries;
import com.springCourse.springBootcamp.User.Enum.RestrictedCountries;
import com.springCourse.springBootcamp.User.Enum.UserStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final SellerDao sellerDao;

    public List<Seller> findAll() {
        return sellerDao.findAll();
    }

    public Seller findAllById(Long Id) {
        return sellerDao.findAllById(Id);
    }

    public Seller findAllByStoreName(String storeName) {
        return sellerDao.findAllByStoreName(storeName);
    }

    public List<Seller> findAllByCountriesThatSells(Countries countriesThatSells) {
        return findAllByCountriesThatSells(countriesThatSells);
    }

    public List<Seller> findAllByUserStatus(UserStatus userStatus) {
        return findAllByUserStatus(userStatus);
    }

    public Seller findAllByUsernameAndPassword(String username, String password) {
        return sellerDao.findAllByUsernameAndPassword(username, password);
    }

    public Seller isSellerSellsToValidCountries(Seller seller) {
        List<String> restrictedCountriesList = List.of(Arrays.toString(RestrictedCountries.class.getEnumConstants()));
        Countries countries = seller.getCountriesThatSells();
        return restrictedCountriesList.contains(countries.toString()) ? seller : null;
    }
}
