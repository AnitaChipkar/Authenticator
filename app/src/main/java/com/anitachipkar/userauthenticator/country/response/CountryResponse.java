package com.anitachipkar.userauthenticator.country.response;

import com.anitachipkar.userauthenticator.country.model.CountryModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryResponse {

    @SerializedName("result")
    @Expose
    private List<CountryModel> countries = null;

    public List<CountryModel> getCountries()
    {
        return countries;
    }

    public void setCountries(List<CountryModel> countries)
    {
        this.countries = countries;
    }
}
