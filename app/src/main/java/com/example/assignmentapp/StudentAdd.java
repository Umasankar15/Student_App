package com.example.assignmentapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StudentAdd extends AppCompatActivity {

    Button btnAdd;
    EditText _sid, _sname, _semail;
    DBHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_add);
        myDB = new DBHelper(this);
        btnAdd = (Button) findViewById(R.id.addStudent);
        _sid = (EditText) findViewById(R.id.studentID);
        _sname = (EditText) findViewById(R.id.studentName);
        _semail = (EditText) findViewById(R.id.studentEmail);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String student_ID = _sid.getText().toString(),
                        student_NAME = _sname.getText().toString(),
                        student_EMAIL = _semail.getText().toString();
                if (!TextUtils.isEmpty(student_ID) && !TextUtils.isEmpty(student_NAME) && !TextUtils.isEmpty(student_EMAIL)) {
                    boolean isInserted = myDB.insertStudent(student_ID, student_NAME, student_EMAIL);
                    if (isInserted)
                        Toast.makeText(getApplicationContext(), "Student Added Successfully", Toast.LENGTH_LONG).show();
                    else
                        Toast.makeText(getApplicationContext(), "Error Adding Student", Toast.LENGTH_LONG).show();
                    _sid.getText().clear();
                    _sname.getText().clear();
                    _semail.getText().clear();
                } else {
                    Toast.makeText(getApplicationContext(), "Please fill all the Details", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
