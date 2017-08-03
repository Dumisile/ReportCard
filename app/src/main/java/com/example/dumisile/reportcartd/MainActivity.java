package com.example.dumisile.reportcartd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.name;
import static com.example.dumisile.reportcartd.R.id.faculty;

public class MainActivity extends AppCompatActivity {
    private EditText StudentNo, StudentName, StudentClass, StudentFaculty, mark1, mark2, mark3, remarks, stdId;
    private TextView average;
    private int id;
    private boolean update;
    private com.example.dumisile.reportcartd.DatabaseHelper sd;
    
    Student student = new Student();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sd = new com.example.dumisile.reportcartd.DatabaseHelper(this);
        StudentNo = (EditText) findViewById(R.id.edtNumber);
        StudentName = (EditText) findViewById(R.id.edtName);
        StudentClass = (EditText) findViewById(R.id.edtClass);
        StudentFaculty = (EditText) findViewById(R.id.edtFaculty);
        mark1 = (EditText) findViewById(R.id.edtMarkOne);
        mark2 = (EditText) findViewById(R.id.edtMarkTwo);
        mark3 = (EditText) findViewById(R.id.edtMarkThree);
        average = (TextView) findViewById(R.id.txtAvg);
        remarks = (EditText) findViewById(R.id.edtRemarks);


    }

    public void add(View view) {
        int i=0;
        int score;

        int StdNo = Integer.parseInt(StudentNo.getText().toString());
        String StdName = StudentName.getText().toString();
        String StdClass = StudentClass.getText().toString();
        String StdFaculty = StudentFaculty.getText().toString();
        int test1 = Integer.parseInt(mark1.getText().toString());
        int test2 = Integer.parseInt(mark2.getText().toString());
        int test3 = Integer.parseInt(mark3.getText().toString());
        String comment = remarks.getText().toString();

        score=(test1+test2+test3)/3;
        average.setText("YOUR AVERAGE MARK IS:" + " " + score);

        Student student = new Student(StdNo,StdName,StdClass,StdFaculty,test1,test2,test3,average.getText().toString(),comment);

        

        sd.addStudent(student);
        Intent intent = new Intent(this, ShowDetails.class);
        startActivity(intent);
    }

    public void delete(View view) {
        StudentName = (EditText) findViewById(R.id.edtName);
        String names = StudentName.getText().toString();
        sd.deleteStudent(names);

        Intent intent = new Intent(this, ShowDetails.class);
        startActivity(intent);

    }

    public void update(View view) {

        int i=0;
        int score;

        int StdNo = Integer.parseInt(StudentNo.getText().toString());
        String StdName = StudentName.getText().toString();
        String StdClass = StudentClass.getText().toString();
        String StdFaculty = StudentFaculty.getText().toString();
        int test1 = Integer.parseInt(mark1.getText().toString());
        int test2 = Integer.parseInt(mark2.getText().toString());
        int test3 = Integer.parseInt(mark3.getText().toString());
        String avg = average.getText().toString();
        String comment = remarks.getText().toString();

        Student student = new Student(StdNo,StdName,StdClass,StdFaculty,test1,test2,test3,avg,comment);

        if (update) {
            student.setStudentNo(StdNo);
            student.setStudentName(StdName);
            student.setStudentClass(StdClass);
            student.setStudentFaculty(StdFaculty);
            student.setMark1(test1);
            student.setMark2(test2);
            student.setMark3(test3);
            student.setAverage(avg);
            student.setRemarks(comment);
            sd.updateShow(student, StudentName.getText().toString());
        } else {
            sd.updateShow(student, StudentName.getText().toString());
        }

        Intent intent = new Intent(this, ShowDetails.class);

        startActivity(intent);

    }
}
