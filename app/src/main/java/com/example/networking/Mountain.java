package com.example.networking;

public class Mountain {
    private String ID;
    private String name;
    private String type;
    private String company;
    private String location;
    private String category;
    private int size;
    private int cost;
    private Auxdata auxdata;

    public Mountain(String name, String location, int size) {
        this.name = name;
        this.location = location;
        this.size = size;
    }


    public Mountain() {
        name = "MISSING";
        location = "MISSING";
        size = -1;
    }

    public String info() {
        String str = new String();
        str += name +
                " is located in " +
                location +
                " and has a height of " +
                size + "m!";
        return str;
    }

    @Override
    public String toString() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setAuxdata(Auxdata auxdata) {
        this.auxdata = auxdata;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }
}

