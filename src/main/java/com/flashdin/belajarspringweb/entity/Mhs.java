package com.flashdin.belajarspringweb.entity;

public class Mhs extends User {
    private String name;
    private String address;

    public Mhs(){

    }

    public Mhs(String nama, String alamat){
        this.name = name;
        this.address = address;
    }

    @Override
    public int getId(){ return id;}

    @Override
    public void setId(int id){this.id = id;}

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
