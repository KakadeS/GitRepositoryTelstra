package com.example.sayalikakade.telstraassignmenttask.helper;



import com.example.sayalikakade.telstraassignmenttask.model.CountryListModel;
import com.example.sayalikakade.telstraassignmenttask.utils.CountryConstants;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET(CountryConstants.TARGET_URL)
    Call<CountryListModel> getCountryDetails();
}
