package com.example.javaprojectfirstapp.Data;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.javaprojectfirstapp.Entities.Travel;

public class TravelRepository {


    private  TravelDataSource travelDataSource;
   public TravelRepository()
    {
        travelDataSource =new TravelDataSource();


    }

    public LiveData<Boolean> getTravelUpdate() {
        return travelDataSource.getIsSuccess();
    }

    public void addTravel(Travel travel) {
        travelDataSource.addTravel(travel);
    }
}
