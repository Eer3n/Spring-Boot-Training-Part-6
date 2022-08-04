package com.springCourse.springBootcamp.User.Enum;

public enum RestrictedCountries {
    iran("Iran"),
    northKorea("NorthKorea"),
    northAmerica("NorthAmerica"),
    africa("Africa");

    private final String restrictedCountries;

    RestrictedCountries(String restrictedCountries) {
        this.restrictedCountries = restrictedCountries;
    }

    @Override
    public String toString() {
        return restrictedCountries;
    }
}