package com.example.networking;

public class Mountain {
    private String name;
    private String location;
    private int height;

    public Mountain(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
    }


    public Mountain() {
        name = "SAKNAS";
        location = "SAKNAS";
        height = -1;
    }

    public String info() {
        String str = new String();
        str += name
                + " is located in "
                + location
                + " and has a height of "
                + height + "m!";
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

    public int getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
