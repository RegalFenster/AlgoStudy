package com.example.algostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondScreen extends AppCompatActivity {

    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);






        findViewById(R.id.newPicture).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             startActivity(new Intent(SecondScreen.this, MainActivity.class));
            }
        });

    }

//doesn't work. I think something is wrong with the manifest

    public void goBackToStart() {
    View newPicture = findViewById(R.id.newPicture);
    button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            startActivity(new Intent(SecondScreen.this, MainActivity.class));
        }
    });

}

}