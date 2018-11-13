package com.example.sayalikakade.telstraassignmenttask.helper;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static Retrofit retrofit;
    public static Retrofit getRetrofitObject() {
        String BASE_URL = "https://dl.dropboxusercontent.com/s/2iodh4vg0eortkl/";
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
