package com.springCourse.springBootcamp.User.Enum;

public enum Countries {
    canada("Canada"),
    usa("USA"),
    china("China"),
    england("England"),
    spain("Spain");

    private final String countryName;

    Countries(String name) {
        countryName = name;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
