package com.example.javaprojectfirstapp.UI.Mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.javaprojectfirstapp.R;
import com.example.javaprojectfirstapp.UI.AddTravel.AddTravelActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
//david bterler 206301384
//dov baker 203301072
public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.BTN_GoToAddTravel);
        button.setBackgroundColor(Color.BLUE);

    }

    public void go_to_add_travel_func(View view) {
        Intent intent = new Intent(this, AddTravelActivity.class);
        startActivity(intent);
    }
}