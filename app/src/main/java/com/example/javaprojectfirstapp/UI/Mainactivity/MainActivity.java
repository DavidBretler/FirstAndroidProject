package com.example.javaprojectfirstapp.UI.Mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.javaprojectfirstapp.R;
import com.example.javaprojectfirstapp.UI.AddTravel.AddTravelActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Write a message to the database

        myRef.setValue("Hello, World!");

    }

    public void go_to_add_travel_func(View view) {
        Toast.makeText(this,"clicked ",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, AddTravelActivity.class);
        startActivity(intent);
    }
}