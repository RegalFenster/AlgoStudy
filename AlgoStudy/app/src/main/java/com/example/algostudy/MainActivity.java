package com.example.algostudy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;


public class MainActivity extends AppCompatActivity {

    public File f;
    private ImageView imageSelected;
    private ImageView imageView;

    public File finalFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSelected = findViewById(R.id.selectedImage);

        findViewById(R.id.mergeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImages();
            }
        });
        findViewById(R.id.mergeInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMergeSort();
            }
        });

        findViewById(R.id.bubbleButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedImages();
            }
//
//                if (ContextCompat.checkSelfPermission(
//                        getApplicationContext(), Manifest.permission.READ_EXTERNAL_STORAGE
//                ) != PackageManager.PERMISSION_GRANTED) {
//                    ActivityCompat.requestPermissions(
//                            MainActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                            REQUEST_CODE_STORAGE_PERMISSION
//                    );
//                } else {
//                    selectImage();
//                }
//
//            }
        });

        findViewById(R.id.bubbleInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBubbleSort();
            }
        });
        findViewById(R.id.insertButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            selectedImages();
            }
        });

        findViewById(R.id.insertInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToInsertSort();
            }
        });




        Button btn = findViewById(R.id.goToSecondScreen);
        Button aboutBtn = findViewById(R.id.aboutButton);
        imageView = findViewById(R.id.picture);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PictureViewer.class);
                intent.putExtra("Path", finalFile);
                startActivity(intent);
            }
        });

        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivity(intent);
            }
        });

    }




    private void selectedImages() {
        final CharSequence[] options = {"Take Photo", "Choose from Gallery", "Cancel"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Add Photo");

        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {


                if (options[item].equals("Take Photo")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    f = new File(android.os.Environment.getExternalStorageDirectory(), "temp.jpg");
                    startActivityForResult(intent, 1);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(intent, 2);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }


    private void goToMergeSort() {
        goToUrl("https://de.wikipedia.org/wiki/Mergesort");
    }

    private void goToBubbleSort() {
        goToUrl("https://de.wikipedia.org/wiki/Bubblesort");
    }

    private void goToInsertSort() {
        goToUrl("https://de.wikipedia.org/wiki/Insertionsort");
    }


    private void goToUrl(String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 || requestCode == 2) {
            assert data != null;
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            convertToByteArray(bitmap);
        }
    }

    private byte[] convertToByteArray(Bitmap bitmap){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,80,stream);
        return stream.toByteArray();
    }
}






