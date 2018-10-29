package com.flashdin.belajarspringweb.entity;

public class MataKuliah extends User {

   private String makul;

    public MataKuliah() {
    }

    public MataKuliah(String makul) {
        this.makul = makul;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getMakul() {
        return makul;
    }

    public void setMakul(String makul) {
        this.makul = makul;
    }
}
