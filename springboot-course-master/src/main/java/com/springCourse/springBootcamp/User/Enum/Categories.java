package com.springCourse.springBootcamp.User.Enum;

public enum Categories {

    phone("Phone"),
    tablet("Tablet"),
    laptop("Laptop"),
    desktop("Desktop"),
    xbox("Xbox"),
    playStation("PlayStation"),
    wii("Wii"),
    earphone("Earphone"),
    charger("Charger"),
    mouse("Mouse");

    private final String categoryName;

    Categories(String name){ categoryName = name;}

    public String toString(){return categoryName;}


}
