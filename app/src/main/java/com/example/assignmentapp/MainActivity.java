package com.example.assignmentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    View screenView;
    Button colorClick, helloBtn, StudentBtn;
    int[] color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        color = new int[]{Color.BLACK, Color.RED, Color.GREEN, Color.GRAY, Color.YELLOW, Color.CYAN, Color.BLUE};
        screenView = findViewById(R.id.rView);
        colorClick = (Button) findViewById(R.id.btn);
        helloBtn = (Button) findViewById(R.id.hlobtn);
        StudentBtn = (Button) findViewById(R.id.studentBtn);

        colorClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int arrLen = color.length;
                Random rand = new Random();
                int rNum = rand.nextInt(arrLen);
                screenView.setBackgroundColor(color[rNum]);
            }
        });

        helloBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SwitchActivity.class);
                startActivity(intent);
            }
        });

        StudentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), StudentApp.class);
                startActivity(intent);
            }
        });
    }
}