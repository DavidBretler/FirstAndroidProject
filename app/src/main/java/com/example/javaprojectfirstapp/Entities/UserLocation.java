
package com.example.javaprojectfirstapp.Entities;

import android.location.Location;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.widget.EditText;
import android.widget.Toast;

import com.example.javaprojectfirstapp.R;

import java.io.IOException;
import java.util.List;
public class UserLocation {}
// TODO: 25/11/2020  implrment
/*
public class UserLocation {



    Location travelLocation;


   // בהנחה שהכתובת הוזנה כמחרוזת ונשאבה מ- EditText   כ- travelAddress

    String travelAddress= ((EditText) findViewById(R.id.travelLocation)).getText().toString();


try {
        List<Address> l = geocoder.getFromLocationName(travelAddress, 1);
        if (!l.isEmpty()) {
            Address temp = l.get(0);
            travelLocation= new Location("travelLocation");
            travelLocation.setLatitude(temp.getLatitude());
            travelLocation.setLongitude(temp.getLongitude());
        } else {
            Toast.makeText(this, "4:Unable to understand address", Toast.LENGTH_LONG).show();
            return true;
        }
    } catch (
    IOException e) {
        Toast.makeText(this, "5:Unable to understand address. Check Internet connection.", Toast.LENGTH_LONG).show();
        return true;
    }
}

}
*/
