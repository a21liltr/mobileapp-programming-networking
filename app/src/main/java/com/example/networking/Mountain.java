package com.example.networking;

import com.google.gson.annotations.SerializedName;

public class Mountain {
    private String name;
    private String location;

    // Using @SerializedName to change name from attribute "size" in json to "height" in code.
    @SerializedName("size")
    private int height;

    public Mountain(String name, String location, int height) {
        this.name = name;
        this.location = location;
        this.height = height;
    }


    public Mountain() {
        name = "MISSING";
        location = "MISSING";
        height = -1;
    }

    public String info() {
        String str = new String();
        str += name +
                " is located in " +
                location +
                " and has a height of " +
                height + "m!";
        return str;
    }

    @Override
    public String toString() {
        return name;
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

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getHeight() {
        return height;
    }
}

