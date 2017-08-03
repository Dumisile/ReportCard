package com.example.dumisile.reportcartd;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;

import junit.framework.Test;

import org.w3c.dom.Text;

import java.sql.SQLOutput;
import java.util.ArrayList;

import static android.R.attr.id;
import static android.R.attr.name;
import static android.R.attr.theme;
import static android.R.attr.version;
import static android.R.attr.x;
import static com.example.dumisile.reportcartd.R.id.average;
import static com.example.dumisile.reportcartd.R.id.faculty;
import static com.example.dumisile.reportcartd.R.id.remarks;

/**
 * Created by DUMISILE on 2017/07/20.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final static int databaseVersion = 4;
    private final static String databaseName = "ReportCarddb";
    private DatabaseHelper databaseHelper;
    private boolean update;
    String TABLE_NAME = "student";
    String STUDENT_NO = "STUDENT_NO";
    static String STUDENT_NAME = "STUDENT_Name";
    String STUDENT_CLASS = "STUDENT_Class";
    String STUDENT_FACULTY = "STUDENT_Faculty";
    String REMARKS = "STUDENT_REMARKS";
    String ID = "ID";
    String MARK1 = "MARK1";
    String MARK2 = "MARK2";
    String MARK3 = "MARK3";
    String AVARAGE = "AVARAGE";

    String mark1, mark2, mark3, average, Id;

    String allStudents, student;
    Student s = new Student();
    static ArrayList<String> students;



    public DatabaseHelper(Context context) {
        super(context, databaseName, null, databaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
                String createTable = "CREATE TABLE " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        STUDENT_NO + " INTEGER NOT NULL, " + STUDENT_NAME + "  TEXT NOT NULL, " + STUDENT_CLASS +
                        "  TEXT NOT NULL, " + STUDENT_FACULTY + "  TEXT NOT NULL, "+ MARK1 + "  INTEGER NOT NULL, "
                        + MARK2 + "  INTEGER NOT NULL, " + MARK3 + "  INTEGER NOT NULL, " + AVARAGE + "  TEXT," + REMARKS + " TEXT NOT NULL) ";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addStudent(Student student) {


        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_NO, student.getStudentNo());
        values.put(STUDENT_NAME, student.getStudentName());
        values.put(STUDENT_CLASS, student.getStudentClass());
        values.put(STUDENT_FACULTY, student.getStudentFaculty());
        values.put(MARK1, student.getMark1());
        values.put(MARK2, student.getMark2());
        values.put(MARK3, student.getMark3());
        values.put(AVARAGE, student.getAverage());
        values.put(REMARKS, student.getRemarks());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public ArrayList<String> getStudents() {
        SQLiteDatabase db = this.getWritableDatabase();
         students = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {

                int stdId = cursor.getInt(0);
                int StudentNo = cursor.getInt(1);
                String StudentName = cursor.getString(2);
                String StudentClass = cursor.getString(3);
                String StudentFaculty = cursor.getString(4);
                int mark1 = cursor.getInt(5);
                int mark2 = cursor.getInt(6);
                int mark3 = cursor.getInt(7);
                String average = cursor.getString(8);
                String remarks = cursor.getString(9);


                String display = stdId + "  " + "Student Name :  " + "    " + StudentName + "   Student Number: " + "  " + StudentNo + "     " + "Class" + StudentClass + "  " + " Faculty : " + "  " + StudentFaculty +
                        "Test 1 :" + mark1 + "  " + "Test 2  :" + mark2 + "   " + "  Test3  :" + mark3 + "   " + "Average mark  : " + average + "  Remarks:  " + "   " + remarks;
                students.add(display);
                System.out.println(display);
            }
            while (cursor.moveToNext());
        }
        return students;
    }

    public int deleteStudent(String x) {
        SQLiteDatabase db = this.getWritableDatabase();
        String[] whereArgs = {x};
        int count = db.delete(this.TABLE_NAME, this.STUDENT_NAME + "=?", whereArgs);
        return count;

    }

    public int updateShow(Student student, String x) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_NO, student.getStudentNo());
        values.put(STUDENT_NAME, student.getStudentName());
        values.put(STUDENT_CLASS, student.getStudentClass());
        values.put(STUDENT_FACULTY, student.getStudentFaculty());
        values.put(MARK1, student.getMark1());
        values.put(MARK2, student.getMark2());
        values.put(MARK3, student.getMark3());
        values.put(AVARAGE, student.getAverage());
        values.put(REMARKS, student.getRemarks());
        String[] args = {x};

        int val = db.update(this.TABLE_NAME,values,this.STUDENT_NAME+"=?" ,args);
        return val;
    }

    public String getAStudent(String id) {


        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT * FROM " + TABLE_NAME + " where " + Id + " = ? ";
        String args[] = {String.valueOf(id)};
        Cursor c = db.rawQuery(selectQuery, args);
        if (c.moveToFirst()) {
            s.setId(c.getInt(c.getColumnIndex(Id)));
            s.setStudentName(c.getString(c.getColumnIndex(STUDENT_NAME)));
            s.setStudentNo(c.getInt(c.getColumnIndex(STUDENT_NO)));
            s.setStudentClass(c.getString(c.getColumnIndex(STUDENT_CLASS)));
            s.setStudentFaculty(c.getString(c.getColumnIndex(STUDENT_FACULTY)));
            s.setMark1(c.getInt(c.getColumnIndex(MARK1)));
            s.setMark2(c.getInt(c.getColumnIndex(MARK2)));
            s.setMark3(c.getInt(c.getColumnIndex(MARK3)));
            s.setAverage(c.getString(c.getColumnIndex(AVARAGE)));
            s.setRemarks(c.getString(c.getColumnIndex(REMARKS)));

            student = c.getString(2).toString();
        }
        return student;

    }

}










