package com.example.sayalikakade.telstraassignmenttask.model;

import android.support.annotation.Nullable;

public class CountryModel {
    private String title;
    private String description;
    private String imageHref;

    public CountryModel() {
    }
    @Nullable
    public String getDescription() {
        return description;
    }

    public void setDescription(@Nullable String description) {
        this.description = description;
    }
    @Nullable
    public String getImageHref() {
        return imageHref;
    }

    public void setImageHref(@Nullable String imageHref) {
        this.imageHref = imageHref;
    }



    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }
}
