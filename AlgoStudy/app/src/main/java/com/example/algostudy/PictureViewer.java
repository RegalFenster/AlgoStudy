package com.example.algostudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.ImageView;

import processing.android.PFragment;
import processing.core.PApplet;

public class PictureViewer extends AppCompatActivity {
    private PApplet sketch;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second_screen);

        imageView = findViewById(R.id.picture);

        FrameLayout frame = findViewById(R.id.container);

        sketch = new Sketch();

        PFragment fragment = new PFragment(sketch);

        fragment.setView(frame, this);


    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        if (sketch != null) {
            sketch.onRequestPermissionsResult(
                    requestCode, permissions, grantResults);
        }
    }
    @Override
    public void onNewIntent(Intent intent) {
        if (sketch != null) {
            sketch.onNewIntent(intent);
        }
    }




}


