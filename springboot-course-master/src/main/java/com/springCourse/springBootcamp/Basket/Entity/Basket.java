package com.springCourse.springBootcamp.Basket.Entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Product.Entity.Product;
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
@Table(name = "SPRING_BASKET", schema = "public")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Basket implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @BatchSize(size = 10)
    @JsonManagedReference
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "basket")
    @ToString.Exclude
    private List<Product> productList = new ArrayList<>();

    @OneToOne
    @JsonBackReference
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    private String productName;
    private int amount;
    private Boolean isEmpty;

    @Override
    public Basket clone() {
        try {
            Basket clone = (Basket) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Basket basket = (Basket) o;
        return Id != null && Objects.equals(Id, basket.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
