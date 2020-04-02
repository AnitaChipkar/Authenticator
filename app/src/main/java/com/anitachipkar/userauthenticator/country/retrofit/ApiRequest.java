package com.anitachipkar.userauthenticator.country.retrofit;

import com.anitachipkar.userauthenticator.country.response.CountryResponse;


import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("/countries_list.json")
    Call<CountryResponse> getCountryNames();
}
