package com.example.sayalikakade.telstraassignmenttask.view;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sayalikakade.telstraassignmenttask.R;
import com.example.sayalikakade.telstraassignmenttask.adapter.DataAdapter;
import com.example.sayalikakade.telstraassignmenttask.model.CountryListModel;
import com.example.sayalikakade.telstraassignmenttask.utils.NetworkUtils;
import com.example.sayalikakade.telstraassignmenttask.viewmodel.CountryViewModel;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class CountryFragment extends Fragment {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    TextView network_check;
    DataAdapter adapter;
    TextView text_toolbar;
    private CountryViewModel countryViewModel;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_container, container, false);
        swipeRefreshLayout = view.findViewById(R.id.refresh_data);
        initRecyclerView(view);
        return view;
    }

    public void onResume() {
        super.onResume();
    }


    private void initRecyclerView(View view) {
        adapter = new DataAdapter();
        recyclerView = view.findViewById(R.id.data_recycler_view);
        network_check = view.findViewById(R.id.network_check);
        text_toolbar = view.findViewById(R.id.text_toolbar);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), VERTICAL));
        if (NetworkUtils.checkNetworkConnection(getActivity())) {
            populateData();
            isNetworkAvailable();
        } else {
            isNetworkNotAvailable();
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
                if (NetworkUtils.checkNetworkConnection(getActivity())) {
                    swipeRefreshLayout.setRefreshing(false);
                    populateData();
                    isNetworkAvailable();
                } else {
                    isNetworkNotAvailable();
                }
            }
        });

    }

    private void populateData() {
        countryViewModel.getCountry().observe(this, new Observer<CountryListModel>() {
            @Override
            public void onChanged(@Nullable CountryListModel countryListModel) {
                if (countryListModel != null) {
                    text_toolbar.setText(countryListModel.title);
                    recyclerView.setAdapter(adapter);
                    adapter.updateData(countryListModel.getRows());
                }
            }
        });
    }

    public void isNetworkAvailable() {
        network_check.setVisibility(View.GONE);
        text_toolbar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.VISIBLE);
    }

    public void isNetworkNotAvailable() {
        network_check.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.GONE);
        text_toolbar.setVisibility(View.GONE);
    }
}
