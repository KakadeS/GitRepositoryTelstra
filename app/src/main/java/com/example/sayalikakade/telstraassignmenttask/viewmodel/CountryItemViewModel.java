package com.example.sayalikakade.telstraassignmenttask.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.example.sayalikakade.telstraassignmenttask.model.CountryModel;


public class CountryItemViewModel extends BaseObservable {
    private CountryModel dataModel;

    public CountryItemViewModel(CountryModel dataModel) {
        this.dataModel = dataModel;
    }

    @Bindable
    public String getTitle() {
        return !TextUtils.isEmpty(dataModel.getTitle()) ? dataModel.getTitle() : "";
    }

    @Bindable
    public String getDescription() {
        return !TextUtils.isEmpty(dataModel.getDescription()) ? dataModel.getDescription() : "";
    }

    @Bindable
    public String getImageHref() {
        return !TextUtils.isEmpty(dataModel.getImageHref()) ? dataModel.getImageHref() : "";

    }

}
