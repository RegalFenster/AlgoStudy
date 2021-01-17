package com.example.algostudy;

import processing.core.PApplet;

public class Sketch extends PApplet {

    float[] values;

    int i = 0;

    public void setup() {

        values = new float[width];
        for (int i = 0; i < values.length; i++) {
            values[i] = random(height);
        }

    }

    public void draw() {
        background(0);
        if (i < values.length) {
            for (int j = 0; j < values.length - i - 1; j++) {
                float a = values[j];
                float b = values[j + 1];
                if (a > b) {
                    swap(values, j, j + 1);
                }
            }
        }else {
            noLoop();
        }
        i++;

        for (int i = 0; i < values.length; i++) {
            stroke(255);
            line(i, height, i, height - values[i]);
        }
    }

    void swap(float[] arr, int a, int b) {
        float temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
