package com.example.sayalikakade.telstraassignmenttask.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.sayalikakade.telstraassignmenttask.helper.ApiInterface;
import com.example.sayalikakade.telstraassignmenttask.helper.RetrofitClass;
import com.example.sayalikakade.telstraassignmenttask.model.CountryListModel;
import com.example.sayalikakade.telstraassignmenttask.model.CountryModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryViewModel extends AndroidViewModel {
    private MutableLiveData<CountryListModel> countryListModelMutableLiveData;

    public CountryViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<CountryListModel> getCountry() {
        countryListModelMutableLiveData = new MutableLiveData<>();
        ApiInterface api = RetrofitClass.getRetrofitObject().create(ApiInterface.class);
        Call<CountryListModel> call = api.getCountryDetails();
        call.enqueue(new Callback<CountryListModel>() {
            @Override
            public void onResponse(@NonNull Call<CountryListModel> call, @NonNull Response<CountryListModel> response) {
                countryListModelMutableLiveData.setValue(filterDataList(response.body()));
            }

            @Override
            public void onFailure(@NonNull Call<CountryListModel> call, Throwable t) {
                countryListModelMutableLiveData.setValue(null);
            }
        });

        return countryListModelMutableLiveData;
    }

    private CountryListModel filterDataList(CountryListModel countryListModel) {
        if (countryListModel != null) {
            for (int i = 0; i < countryListModel.getRows().size(); i++) {
                CountryModel countryModel = countryListModel.getRows().get(i);
                if (countryModel.getTitle() == null && countryModel.getDescription() == null && countryModel.getImageHref() == null) {
                    countryListModel.getRows().remove(countryModel);
                } else if (countryModel.getDescription() == null) {
                    countryModel.setDescription("Description does not exist");
                }
            }
        }
        return countryListModel;
    }
}
