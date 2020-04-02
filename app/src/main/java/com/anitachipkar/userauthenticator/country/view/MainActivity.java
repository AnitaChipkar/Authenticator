package com.anitachipkar.userauthenticator.country.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import com.anitachipkar.userauthenticator.R;
import com.anitachipkar.userauthenticator.country.adapter.CountryAdapter;
import com.anitachipkar.userauthenticator.country.model.CountryModel;
import com.anitachipkar.userauthenticator.country.viewmodel.CountryViewModel;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewCountry;
    ProgressBar progressBar;
    private CountryAdapter countryAdapter;
    private ArrayList<CountryModel> countryModelArrayList = new ArrayList<>();
    CountryViewModel countryViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Set back button
        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initialization();
        callCountryNames();
    }

    private void initialization() {
        recyclerViewCountry = findViewById(R.id.recyclerview_country);
        progressBar = findViewById(R.id.progressBar);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerViewCountry.setLayoutManager(linearLayoutManager);
        recyclerViewCountry.setHasFixedSize(true);
        recyclerViewCountry.addItemDecoration(new DividerItemDecoration(recyclerViewCountry.getContext(), DividerItemDecoration.VERTICAL));
        countryAdapter = new CountryAdapter(this,countryModelArrayList);
        recyclerViewCountry.setAdapter(countryAdapter);
        countryViewModel = ViewModelProviders.of(this).get(CountryViewModel.class);
    }

    private void callCountryNames() {

        countryViewModel.getCountryResponseLiveData().observe(this, articleResponse -> {
            if (articleResponse != null) {

                progressBar.setVisibility(View.GONE);
                List<CountryModel> countries = articleResponse.getCountries();
                countryModelArrayList.addAll(countries);
                countryAdapter.notifyDataSetChanged();
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);

    }
  // On BackPress to exit app
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent homeIntent = new Intent(Intent.ACTION_MAIN);
        homeIntent.addCategory( Intent.CATEGORY_HOME );
        homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(homeIntent);
    }
}
