package com.liwenxiang.demoexpandablelistview2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwenxiang on 2015/11/11.
 */
public class Classroom {
    public int order;
    public int numberOfStudents;
    public List<Student> students;

    Classroom(int order, int numberOfStudents) {
        this.order = order;
        this.numberOfStudents = numberOfStudents;
        students = new ArrayList<>();
        for (int i = 1; i <= numberOfStudents; i++) {
            students.add(new Student("学生" + String.valueOf(i), i));
        }
    }

    class Student {
        String name;
        int number;

        Student(String name, int number) {
            this.name = name;
            this.number = number;
        }
    }
}
