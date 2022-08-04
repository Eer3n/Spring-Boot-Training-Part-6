package com.springCourse.springBootcamp.User.Enum;

import com.springCourse.springBootcamp.Seller.Entity.Seller;

public enum SellerStatus {
    active("Active"),
    inactive("Inactive"),
    banned("Banned");

    public final String sellerStatus;

    SellerStatus(String sellerStatus){this.sellerStatus=sellerStatus;}

    @Override
    public String toString(){return sellerStatus;}
}
