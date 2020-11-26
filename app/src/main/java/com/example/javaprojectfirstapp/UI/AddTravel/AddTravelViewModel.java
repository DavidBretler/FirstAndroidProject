package com.example.javaprojectfirstapp.UI.AddTravel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.javaprojectfirstapp.Data.TravelRepository;
import com.example.javaprojectfirstapp.Entities.Travel;

public class AddTravelViewModel extends ViewModel {
    private TravelRepository travelRepository;

    public AddTravelViewModel() {

        travelRepository = new TravelRepository();
    }

    public LiveData<Boolean> getTravelUpdate() {
        return travelRepository.getTravelUpdate();
    }

    public void addTravel(Travel travel) {
        travelRepository.addTravel(travel);
    }
}

