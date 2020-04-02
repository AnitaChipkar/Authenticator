package com.anitachipkar.userauthenticator.country.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anitachipkar.userauthenticator.country.repository.CountryRepository;
import com.anitachipkar.userauthenticator.country.response.CountryResponse;

public class CountryViewModel extends AndroidViewModel {

    private CountryRepository countryRepository;
    private LiveData<CountryResponse> countryResponseLiveData;

    public CountryViewModel(@NonNull Application application) {
        super(application);

        countryRepository = new CountryRepository();
        this.countryResponseLiveData = countryRepository.getCountryNames();
    }

    public LiveData<CountryResponse> getCountryResponseLiveData() {
        return countryResponseLiveData;
    }
}
