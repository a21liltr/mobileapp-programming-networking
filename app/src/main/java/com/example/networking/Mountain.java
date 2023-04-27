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

    @Override
    public String toString() { // Used to return name of the mountain in console.
        return name;
    }

    public String info() {
        String s = name
                + " is located in " + location
                + " and has a height of " + height + " m above sea level.";

        return s;
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

