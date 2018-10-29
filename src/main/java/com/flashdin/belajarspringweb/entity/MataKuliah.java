package com.flashdin.belajarspringweb.entity;

public class MataKuliah extends User {

   private String makul;

    public MataKuliah() {
    }

    public MataKuliah(String makul) {
        this.makul = makul;
    }

    @Override
    public int getUSER_ID() {
        return USER_ID;
    }

    @Override
    public void setUSER_ID(int id) {
        this.USER_ID = USER_ID;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }
}
