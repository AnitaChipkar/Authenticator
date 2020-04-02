package com.anitachipkar.userauthenticator.country.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.anitachipkar.userauthenticator.R;
import com.anitachipkar.userauthenticator.country.model.CountryModel;
import java.util.ArrayList;

public class CountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Activity context;
    ArrayList<CountryModel> countryModels;

    public CountryAdapter(Activity context , ArrayList<CountryModel> countryModelArrayList)
    {
        this.context = context;
        countryModels = countryModelArrayList;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.layout_list_item,parent,false);
        return new CountryViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        CountryModel countryModel = countryModels.get(position);
        CountryViewHolder countryViewHolder = (CountryViewHolder) holder;
        countryViewHolder.textCountryName.setText(countryModel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,countryModels.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return countryModels.size();
    }
    class CountryViewHolder extends RecyclerView.ViewHolder
    {

        TextView textCountryName;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            textCountryName = itemView.findViewById(R.id.textCountryName);
        }
    }
}
