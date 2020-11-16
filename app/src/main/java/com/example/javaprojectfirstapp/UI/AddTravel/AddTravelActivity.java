package com.example.javaprojectfirstapp.UI.AddTravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.javaprojectfirstapp.R;

public class AddTravelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_travel);
    }

    public void add_Address(View view) {
        TextView et= new TextView(AddTravelActivity.this);
        ll.addView(et);
    }
}