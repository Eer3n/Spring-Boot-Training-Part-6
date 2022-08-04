package com.springCourse.springBootcamp.User.Enum;

public enum ProductApproval {
    inApproved("InApproved"),
    approved("Approved"),
    rejected("Rejected"),
    catalogRejected("CatalogRejected"),
    waitingForApproval("WaitingForApproval");

    private final String productApproval;

    ProductApproval(String productStatus){this.productApproval = productStatus;}

    @Override
    public String toString(){ return productApproval;}


}
