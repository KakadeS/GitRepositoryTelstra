package com.example.sayalikakade.telstraassignmenttask.helper;

import com.example.sayalikakade.telstraassignmenttask.utils.CountryConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClass {
    private static Retrofit retrofit;
    public static Retrofit getRetrofitObject() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(CountryConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
