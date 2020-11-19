package com.example.javaprojectfirstapp.UI.AddTravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javaprojectfirstapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class AddTravelActivity extends AppCompatActivity {
final Integer NUM_OF_FILDES=8;

    private List<EditText> fieldsArr = new ArrayList<EditText>(NUM_OF_FILDES);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);
        fieldsArr.add(0, findViewById(R.id.Txt_Email));
        fieldsArr.add(1, findViewById(R.id.Txt_phone));
        fieldsArr.add(2, findViewById(R.id.Txt_NumPassengers));
        fieldsArr.add(3,findViewById(R.id.Txt_name));
        fieldsArr.add(4, findViewById(R.id.Txt_pickupAddress));
        fieldsArr.add(5,findViewById(R.id.Txt_destAddress));
        fieldsArr.add(6, findViewById(R.id.Txt_DepartingDate));
        fieldsArr.add(7, findViewById(R.id.Txt_returnDate));

    }

    private boolean validation(EditText InputId) {
        String Input = InputId.getText().toString().trim();
        if (Input.isEmpty()) {
            InputId.setError("Field can't be empty");
            return false;
        } else
            switch (fieldsArr.indexOf(InputId)) {
                case 0:
                  return  validateEmail();

                case 1:
                  return validatePhone();

                case 2:
                     return validateNumOfPassenger();

                default: {
                    InputId.setError(null);
                    return true;
                }
            }
        //else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
        // textInputEmail.setError("Please enter a valid email address");
        // return false;}
        //


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

    private boolean validateNumOfPassenger() {
        String numOfPassngerInput = fieldsArr.get(2).getText().toString().trim();
      if (!TextUtils.isDigitsOnly(numOfPassngerInput) )
        {
            fieldsArr.get(2).setError("Please enter a valid number");
            return false;
        } else {
            fieldsArr.get(2).setError(null);
            return true;
        }
    }

   // LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout2);
    public void add_Address(View view) {
        //    EditText et= new EditText(AddTravelActivity.this);
        //    ll.addView(et);}
    }




    public boolean confirmInput(View v) {
       boolean flag=true;
        for (EditText field:fieldsArr) {
            if (!validation(field))
                flag =false;
        }

             return flag;
    }

    public void save_travel_request(View view) {
        if(confirmInput(view))
        Toast.makeText(this, "Save successfully", Toast.LENGTH_LONG).show();
    }
    }
