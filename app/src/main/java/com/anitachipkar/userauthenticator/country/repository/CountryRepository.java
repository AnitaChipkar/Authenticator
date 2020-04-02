package com.anitachipkar.userauthenticator.country.repository;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.anitachipkar.userauthenticator.country.response.CountryResponse;
import com.anitachipkar.userauthenticator.country.retrofit.ApiRequest;
import com.anitachipkar.userauthenticator.country.retrofit.RetrofitRequest;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryRepository {

    private ApiRequest apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);

    public LiveData<CountryResponse> getCountryNames() {
        final MutableLiveData<CountryResponse> data = new MutableLiveData<>();
        apiRequest.getCountryNames()
                .enqueue(new Callback<CountryResponse>() {
                    @Override
                    public void onResponse(@NonNull Call<CountryResponse> call, @NonNull Response<CountryResponse> response) {
                        Log.e( "onResponse " ,new Gson().toJson(response.body()));
                        if (response.body() != null) {
                            data.setValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<CountryResponse> call, @NonNull Throwable t) {
                        data.setValue(null);
                    }
                });
        return data;
    }
}
