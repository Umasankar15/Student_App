package com.example.assignmentapp;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class StudentSearch extends AppCompatActivity {

    Button btnSrch;
    EditText _sid;
    DBHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_search);
        btnSrch = (Button) findViewById(R.id.studentSR);
        _sid = (EditText) findViewById(R.id.studentsrch);
        myDB = new DBHelper(this);

        btnSrch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cur = myDB.fetchStudent(Integer.parseInt(_sid.getText().toString()));

                if (cur.getCount() == 0) {
                    showMessage("Error", "No Student Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (cur.moveToNext()) {
                    buffer.append("ID: " + cur.getString(0) + "\n");  // 0 is index here shows columns in database
                    buffer.append("Name: " + cur.getString(1) + "\n");
                    buffer.append("Email: " + cur.getString(2) + "\n");

                }

                showMessage("Student Details", buffer.toString());
            }
        });
    }

    // Method to show database table
    private void showMessage(String title, String Message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}