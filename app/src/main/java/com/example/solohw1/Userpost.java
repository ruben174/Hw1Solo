package com.example.solohw1;

import com.google.gson.annotations.SerializedName;

public class Userpost {

    private int userId;
    @SerializedName("body")
    private String body;


    public int getId() {
        return userId;
    }

    public String getBody() {
        return body;
    }
}
