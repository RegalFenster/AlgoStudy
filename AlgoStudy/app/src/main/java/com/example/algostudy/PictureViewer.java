package com.example.algostudy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;
import java.io.File;

import processing.android.PFragment;
import processing.android.CompatUtils;
import processing.core.PApplet;

public class PictureViewer extends AppCompatActivity {
    private PApplet sketch;
    Button button;
    Intent intent;
    private ImageView imageView;
    public File finalFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);
        imageView = findViewById(R.id.picture);
        FrameLayout frame = findViewById(R.id.container);
       // frame.setId(CompatUtils.getUniqueViewId());
        //setContentView(frame, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
        //        ViewGroup.LayoutParams.MATCH_PARENT));

        sketch = new Sketch(getIntent().getExtras().get("data"));
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


