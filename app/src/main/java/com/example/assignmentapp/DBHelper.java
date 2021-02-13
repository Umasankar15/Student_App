package com.example.assignmentapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;

    //Database, version and Table names
    private static final int version = 1;
    private static final String DATABASE_NAME = "STUDENT.DB";
    private static final String TABLE_NAME = "STUDENT";

    //Columns
    private final String COLUMN_1 = "Student_ID";
    private final String COLUMN_2 = "Student_NAME";
    private final String COLUMN_3 = "Student_Email";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creating a table with Student_id and Student Name
        String create_table_student = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_1 + " INTEGER PRIMARY KEY NOT NULL ,"
                + COLUMN_2 + " TEXT NOT NULL ,"
                + COLUMN_3 + " TEXT) ";
        db.execSQL(create_table_student);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed, all data will be gone!!!
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    //Insert Student Details into the Student DB
    public boolean insertStudent(String studentId, String studentName, String studentEmail) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_1, studentId);
        contentValues.put(COLUMN_2, studentName);
        contentValues.put(COLUMN_3, studentEmail);
        long doInsert = db.insert(TABLE_NAME, null, contentValues);
        if (doInsert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor fetchStudent(int sid){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from " +TABLE_NAME+" WHERE "+COLUMN_1+"="+sid,null);
        return cur;
    }
}
