package com.springCourse.springBootcamp.Product.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springCourse.springBootcamp.Basket.Entity.Basket;
import com.springCourse.springBootcamp.Buyer.Entity.Buyer;
import com.springCourse.springBootcamp.Seller.Entity.Seller;
import com.springCourse.springBootcamp.User.Enum.Gender;
import com.springCourse.springBootcamp.User.Enum.ProductApproval;
import com.springCourse.springBootcamp.User.Enum.SellerStatus;
import lombok.Data;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.BatchSize;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @BatchSize(size= 4)
    @JsonManagedReference
    @OneToMany(orphanRemoval = true, fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, mappedBy = "product")
    @ToString.Exclude
    private List<Product> productApprovalList = new ArrayList<>();

    @Enumerated(EnumType.ORDINAL)
    private ProductApproval productApproval;
    private SellerStatus sellerStatus;


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

    ProductApproval newProduct = ProductApproval.waitingForApproval;



}
