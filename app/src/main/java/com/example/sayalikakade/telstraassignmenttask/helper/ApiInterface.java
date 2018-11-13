package com.example.sayalikakade.telstraassignmenttask.helper;



import com.example.sayalikakade.telstraassignmenttask.model.CountryListModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("facts.json")
    Call<CountryListModel> getCountryDetails();
}
