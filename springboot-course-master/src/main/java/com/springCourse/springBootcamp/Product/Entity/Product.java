package com.springCourse.springBootcamp.Product.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.springCourse.springBootcamp.Basket.Entity.Basket;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "SPRING_PRODUCT", schema = "public")
@Data
public class Product implements Serializable, Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "seller_id")
    private Seller seller;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    @ManyToOne
    @JoinColumn(name = "basket_id")
    private Basket basket;

    private String title;
    private String shortText;

    @Column(columnDefinition = "TEXT")
    private String longText;

    private Date insDate;
    private Date updDate;
    private double displayPrice;
    private double discountPrice;
    private Boolean isDeleted;

    @Override
    public Product clone() {
        try {
            Product clone = (Product) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
