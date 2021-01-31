package com.example.assignmentapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StudentApp extends AppCompatActivity{
    Button studentAdd, studentSearch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_app);
        studentAdd = (Button) findViewById(R.id.studentAdd);
        studentSearch = (Button) findViewById(R.id.studentSearch);

        studentAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentApp.this, StudentAdd.class);
                startActivity(intent);
            }
        });
        studentSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentApp.this, StudentSearch.class);
                startActivity(intent);
            }
        });
    }
}
