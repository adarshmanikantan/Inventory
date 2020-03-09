package com.adarsh.smartinventory.Retro;

import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

public class Api_client {
    private static Retrofit retrofit = null;

    public static Retrofit SmartInventory() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://smartsicss.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}