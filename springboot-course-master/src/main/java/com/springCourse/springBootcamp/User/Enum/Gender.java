package com.springCourse.springBootcamp.User.Enum;

public enum Gender {
    MALE("Male"), FEMALE("Female"), OTHER("I prefer not to say");

    private final String gender;

    Gender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return gender;
    }
}
