package com.example.dumisile.reportcartd;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ShowDetails extends AppCompatActivity {
    private boolean update;
    DatabaseHelper sd = new DatabaseHelper(this);
    private int id;


    Button btnADD, btnDELETE, btnUpdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);
        ArrayList<String> studentArr = sd.getStudents();

        ListView lv= (ListView) findViewById(R.id.list);
        btnADD = (Button) findViewById(R.id.btnADD);
        btnDELETE = (Button) findViewById(R.id.btnDELETE);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        final Student student = new Student();

//        sd.getStudents();
        ArrayList list = new ArrayList();
        list.add("HHH");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, studentArr);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  student = sd.deleteStudent();
                AlertDialog.Builder dialog=new AlertDialog.Builder(ShowDetails.this);
                dialog.setTitle("STUDENT REPORT CARD");
                dialog.setMessage("Are you sure you want to ?");
                dialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent intent =new Intent(ShowDetails.this,MainActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.show();
            }
        });
    }
    public void addStudent(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void delete(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public void update(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}

