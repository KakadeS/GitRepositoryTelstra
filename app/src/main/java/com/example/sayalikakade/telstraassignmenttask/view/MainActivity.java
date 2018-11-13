package com.example.sayalikakade.telstraassignmenttask.view;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.sayalikakade.telstraassignmenttask.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCountryData();
    }

    public void setCountryData() {
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CountryFragment country_fragment = new CountryFragment();
        fragmentTransaction.replace(R.id.country_fragment, country_fragment);
        fragmentTransaction.commit();
    }
}
