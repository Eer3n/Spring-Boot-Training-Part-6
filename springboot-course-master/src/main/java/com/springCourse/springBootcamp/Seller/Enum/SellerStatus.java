package com.springCourse.springBootcamp.Seller.Enum;

public enum SellerStatus {
    active("Active"),
    inactive("Inactive"),
    banned("Banned");

    public final String sellerStatus;

    SellerStatus(String sellerStatus){this.sellerStatus=sellerStatus;}

    @Override
    public String toString(){return sellerStatus;}
}
