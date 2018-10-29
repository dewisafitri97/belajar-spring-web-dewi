package com.flashdin.belajarspringweb.entity;

public class User {

    protected int USER_ID;
    private String USER_NAME;
    private String ENCRYTED_PASSWORD;

    public User() {

    }

    public User(int USER_ID, String USER_NAME, String ENCRYTED_PASSWORD) {
        this.USER_ID = USER_ID;
        this.USER_NAME = USER_NAME;
        this.ENCRYTED_PASSWORD = ENCRYTED_PASSWORD;
    }

    public int getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(int USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

    public String getENCRYTED_PASSWORD() {
        return ENCRYTED_PASSWORD;
    }

    public void setENCRYTED_PASSWORD(String ENCRYTED_PASSWORD) {
        this.ENCRYTED_PASSWORD = ENCRYTED_PASSWORD;
    }
}
