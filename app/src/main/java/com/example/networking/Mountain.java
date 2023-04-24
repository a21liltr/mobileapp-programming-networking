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
        name = "SAKNAS";
        location = "SAKNAS";
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


    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSize() {
        return size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

