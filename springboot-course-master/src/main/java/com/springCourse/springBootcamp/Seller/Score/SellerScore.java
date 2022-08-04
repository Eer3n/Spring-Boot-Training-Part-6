package com.springCourse.springBootcamp.Seller.Score;

import com.springCourse.springBootcamp.Seller.Enum.SellerStatus;

import java.io.Serializable;

public interface SellerScore extends Serializable {

    public SellerStatus deleteScore();
}
