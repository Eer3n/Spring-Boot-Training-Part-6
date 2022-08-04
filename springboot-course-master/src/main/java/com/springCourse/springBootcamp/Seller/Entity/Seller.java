package com.springCourse.springBootcamp.Seller.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springCourse.springBootcamp.Product.Entity.Product;
import com.springCourse.springBootcamp.Seller.Enum.SellerStatus;
import com.springCourse.springBootcamp.User.Entity.User;
import com.springCourse.springBootcamp.User.Enum.Countries;
import com.springCourse.springBootcamp.User.Enum.UserStatus;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "SPRING_SELLER", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Seller extends User implements Serializable {

    public static final int revokeLimit = -100;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String username;
    private String mailAddress;
    private String password;
    private String storeName;
    private int totalProducts;
    private int totalScore;
    private Countries countriesThatSells;
    private UserStatus userStatus;

    @Enumerated(EnumType.ORDINAL)
    private SellerStatus sellerStatus;

    @BatchSize(size = 10)
    @JsonManagedReference
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "seller")
    @ToString.Exclude
    private List<Product> productList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Seller seller = (Seller) o;
        return Id != null && Objects.equals(Id, seller.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
