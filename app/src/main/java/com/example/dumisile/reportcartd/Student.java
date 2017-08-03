package com.example.dumisile.reportcartd;

import static com.example.dumisile.reportcartd.R.id.average;

/**
 * Created by DUMISILE on 2017/07/20.
 */

public class Student {
    private String StudentName, StudentClass, StudentFaculty, remarks, Average;
    private int StudentNo, Mark1, Mark2, Mark3, id;

    public Student(int studentNo, String studentName, String studentClass, String studentFaculty, int mark1, int mark2, int mark3, String average, String remarks) {
        StudentNo = studentNo;
        StudentName = studentName;
        StudentClass = studentClass;
        StudentFaculty = studentFaculty;
        Average = average;
        Mark1 = mark1;
        Mark2 = mark2;
        Mark3 = mark3;
        this.remarks = remarks;
        this.id = id;
    }


    public Student() {

    }

    public int getStudentNo() {
        return StudentNo;
    }

    public void setStudentNo(int studentNo) {
        StudentNo = studentNo;
    }

    public String getStudentName() {
        return StudentName;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public String getStudentFaculty() {
        return StudentFaculty;
    }

    public void setStudentFaculty(String studentFaculty) {
        StudentFaculty = studentFaculty;
    }

    public String getAverage() {
        return Average;
    }

    public void setAverage(String average) {
        Average = average;
    }

    public int getMark1() {
        return Mark1;
    }

    public void setMark1(int mark1) {
        Mark1 = mark1;
    }

    public int getMark2() {
        return Mark2;
    }

    public void setMark2(int mark2) {
        Mark2 = mark2;
    }

    public int getMark3() {
        return Mark3;
    }

    public void setMark3(int mark3) {
        Mark3 = mark3;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
