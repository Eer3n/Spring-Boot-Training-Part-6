package com.springCourse.springBootcamp.User.Enum;

public enum UserStatus {
    active("Active"),
    disabled("Disabled"),
    banned("Banned"),
    notBanned("Not_Banned");

    private final String userStatus;

    UserStatus(String status) {
        userStatus = status;
    }

    @Override
    public String toString() {
        return userStatus;
    }
}