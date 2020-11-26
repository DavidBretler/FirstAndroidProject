package com.example.javaprojectfirstapp.UI.AddTravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.location.Location;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

//import com.example.javaprojectfirstapp.Data.TravelDataSource;
import com.example.javaprojectfirstapp.Entities.Travel;
import com.example.javaprojectfirstapp.Entities.UserLocation;
import com.example.javaprojectfirstapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AddTravelActivity extends AppCompatActivity {

    final Integer NUM_OF_FILDES = 8;
    private Travel travel;
    private List<EditText> fieldsArr = new ArrayList<EditText>(NUM_OF_FILDES);
    UserLocation userLocation ;
    DatePickerDialog picker;
    EditText eText;
    EditText eText2;
    private AddTravelViewModel addTravelViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);


        addTravelViewModel = new ViewModelProvider(this).get(AddTravelViewModel.class);
        addTravelViewModel.getTravelUpdate().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean flag) {
                if (flag)
                    success();

            }
        });

        ///array of input fields
        fieldsArr.add(0, findViewById(R.id.Txt_Email));
        fieldsArr.add(1, findViewById(R.id.Txt_phone));
        fieldsArr.add(2, findViewById(R.id.Txt_NumPassengers));
        fieldsArr.add(3, findViewById(R.id.Txt_name));
        fieldsArr.add(4, findViewById(R.id.Txt_pickupAddress));
        fieldsArr.add(5, findViewById(R.id.Txt_destAddress));
        fieldsArr.add(6, findViewById(R.id.Txt_departingDate));
        fieldsArr.add(7, findViewById(R.id.Txt_returnDate));

        //set date etext as type null so keyboard wont open
        eText = (EditText) fieldsArr.get(6);
        eText.setInputType(InputType.TYPE_NULL);
        eText2 = (EditText) fieldsArr.get(7);
        eText2.setInputType(InputType.TYPE_NULL);
        String a = ((EditText)findViewById(R.id.Txt_pickupAddress)).getText().toString();
    }

    /**
     * opens calender to pick the dates
     * @param Etextview
     */
    public void chooseDate(View Etextview) {

        final Calendar cldr = Calendar.getInstance();
        int day = cldr.get(Calendar.DAY_OF_MONTH);
        int month = cldr.get(Calendar.MONTH);
        int year = cldr.get(Calendar.YEAR);
            picker = new DatePickerDialog(AddTravelActivity.this,
                    new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                            eText = (EditText)Etextview;
                            eText.setText(year+"-"+monthOfYear+"-"+dayOfMonth);
                        }
                    }, year, month, day);
        picker.show();
    }

    public void showDepartingDate(View view) {
        Toast.makeText(this, "Selected departing Date: " + eText.getText(), Toast.LENGTH_LONG).show();
       // Toast.makeText(this, fieldsArr.get(2).getText().toString(), Toast.LENGTH_LONG).show();
    }

    public void showReturnDate(View view) {
        Toast.makeText(this, "Selected return Date: " + eText2.getText(), Toast.LENGTH_LONG).show();
    }

    public void success() {
        Toast.makeText(this, "Travel saved successfully  ", Toast.LENGTH_LONG).show();
    }

    // LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout2);
    public void addAddress(View view) {
        // TODO: 25/11/2020  impkement
        //    EditText et= new EditText(AddTravelActivity.this);
        //    ll.addView(et);}
    }

    public void saveTravelRequest(View view) throws ParseException {

    //   if (confirmInput(view)) {
            Date departingDate=new Travel.DateConverter().fromTimestamp(fieldsArr.get(6).getText().toString().trim());
            Date returnDate=new Travel.DateConverter().fromTimestamp(fieldsArr.get(7).getText().toString().trim());
            int NumPassengers=Integer.parseInt(fieldsArr.get(2).getText().toString().trim());

            userLocation=new UserLocation();

 //           Travel.UserLocationConverter locatin=new Travel.UserLocationConverter();
//            locatin.LocationFromString(fieldsArr.get(4).getText().toString().trim());
//            UserLocation pickupAddress= userLocation.convertFromLocation(locatin.travelLocation);
//
//            locatin.LocationFromString(fieldsArr.get(5).getText().toString().trim());
//            UserLocation destAddress= userLocation.convertFromLocation(locatin.travelLocation);

            UserLocation pickupAddress =userLocation.convertFromLocation(
                    new Travel.UserLocationConverter().LocationFromString(fieldsArr.get(4).getText().toString().trim()));
        //    UserLocation destAddress =new Travel.UserLocationConverter().fromString(fieldsArr.get(5).getText().toString().trim());
       // UserLocation pickupAddress =new UserLocation();
        UserLocation destAddress =new UserLocation();
            travel = new Travel(fieldsArr.get(3).getText().toString().trim(), fieldsArr.get(1).getText().toString().trim()
                    , fieldsArr.get(0).getText().toString().trim(),departingDate,returnDate, NumPassengers,pickupAddress,destAddress);
            addTravel(travel);
            Toast.makeText(this, "detail sent down", Toast.LENGTH_LONG).show();
   //     }
    }

    public void addTravel(Travel travel) {
        addTravelViewModel.addTravel(travel);

    }

    public boolean confirmInput(View v) {
        boolean flag = true;
        for (EditText field : fieldsArr) {
            if (!validation(field))
                flag = false;
        }

        return flag;
    }

    private boolean validation(EditText InputId) {
        String Input = InputId.getText().toString().trim();
        if (Input.isEmpty()) {
            InputId.setError("Field can't be empty");
            return false;
        } else
            switch (fieldsArr.indexOf(InputId)) {
                case 0:
                    return validateEmail();

                case 1:
                    return validatePhone();

                case 2:
                    return validateNumOfPassenger();

                case 3:
                    return validateName();

                default: {
                    InputId.setError(null);
                    return true;
                }
            }
    }

    private boolean validateEmail() {
        String emailInput = fieldsArr.get(0).getText().toString().trim();

        if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            fieldsArr.get(0).setError("Please enter a valid email address");
            return false;
        } else {
            fieldsArr.get(0).setError(null);
            return true;
        }
    }

    private boolean validatePhone() {
        String phoneInput = fieldsArr.get(1).getText().toString().trim();
        if (!Patterns.PHONE.matcher(phoneInput).matches()) {
            fieldsArr.get(1).setError("Please enter a valid phone number");
            return false;
        } else {
            fieldsArr.get(1).setError(null);
            return true;
        }
    }

    private boolean validateName() {
        String nameInput = fieldsArr.get(3).getText().toString().trim();
        if (nameInput.matches(".*\\d.*")) {
            fieldsArr.get(3).setError("Please enter a valid name");
            return false;
        } else {
            fieldsArr.get(3).setError(null);
            return true;
        }
    }

    private boolean validateNumOfPassenger() {
        String numOfPassngerInput = fieldsArr.get(2).getText().toString().trim();
        if (!TextUtils.isDigitsOnly(numOfPassngerInput)) {
            fieldsArr.get(2).setError("Please enter a valid number");
            return false;
        } else {
            fieldsArr.get(2).setError(null);
            return true;
        }
    }


}
