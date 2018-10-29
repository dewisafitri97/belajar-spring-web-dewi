package com.flashdin.belajarspringweb.entity;

public class Mahasiswa extends User {
    private String name;
    private String address;

    public Mahasiswa(){

    }

    public Mahasiswa(String nama, String alamat){
        this.name = name;
        this.address = address;
    }

    @Override
    public int getUSER_ID(){ return USER_ID;}

    @Override
    public void setUSER_ID(int id){this.USER_ID = USER_ID;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
