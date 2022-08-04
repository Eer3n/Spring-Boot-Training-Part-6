package com.springCourse.springBootcamp.Product.Enum;

public enum ProductApproval {

    inApproved("InApproved"),
    approved("Approved"),
    rejected("Rejected"),
    catalogRejected("CatalogRejected"),
    waitingForApproval("WaitingForApproval"),
    softDeleted("soft-deleted");

    private final String productApproval;

    ProductApproval(String productStatus) {
        this.productApproval = productStatus;
    }

    @Override
    public String toString() {
        return productApproval;
    }
}
