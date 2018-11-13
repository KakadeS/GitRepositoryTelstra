package com.example.sayalikakade.telstraassignmenttask.adapter;

import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.example.sayalikakade.telstraassignmenttask.R;
import com.example.sayalikakade.telstraassignmenttask.model.CountryModel;
import com.example.sayalikakade.telstraassignmenttask.viewmodel.CountryItemViewModel;
import com.example.sayalikakade.telstraassignmenttask.databinding.CountryItemBinding;
import java.util.ArrayList;
import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder> {
    private static final String TAG = "DataAdapter";
    private List<CountryModel> data;

    public DataAdapter() {
        this.data = new ArrayList<>();
    }

    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_item,
                new FrameLayout(parent.getContext()), false);
        return new DataViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DataViewHolder holder, int position) {
        CountryModel dataModel = data.get(position);
        holder.setViewModel(new CountryItemViewModel(dataModel));
    }

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public void onViewAttachedToWindow(DataViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        holder.bind();
    }

    @Override
    public void onViewDetachedFromWindow(DataViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.unbind();
    }

    public void updateData(@Nullable List<CountryModel> data) {
            this.data.clear();
      if (data != null && !data.isEmpty()) {
            this.data.addAll(data);
       }
        notifyDataSetChanged();
    }

    @BindingAdapter({"imageHref"})
    public static void loadImage(ImageView imageView, String imageUrl) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .placeholder(R.drawable.loading)
                .into(imageView);

    }


    static class DataViewHolder extends RecyclerView.ViewHolder {
        CountryItemBinding binding;

        DataViewHolder(View itemView) {
            super(itemView);
            bind();
        }

         void bind() {
            if (binding == null) {
                binding = DataBindingUtil.bind(itemView);
            }
        }

         void unbind() {
            if (binding != null) {
                binding.unbind();
            }
        }

         void setViewModel(CountryItemViewModel viewModel) {
            if (binding != null) {
                binding.setViewModel(viewModel);
            }
        }
    }
}
