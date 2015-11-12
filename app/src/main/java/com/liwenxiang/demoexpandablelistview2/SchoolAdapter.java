package com.liwenxiang.demoexpandablelistview2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by liwenxiang on 2015/11/11.
 */
public class SchoolAdapter extends BaseExpandableListAdapter {
    private final Activity activity;
    private List<Classroom> classrooms;

    SchoolAdapter (Activity activity, List<Classroom> classrooms) {
        this.activity = activity;
        this.classrooms = classrooms;
    }

    @Override
    public int getGroupCount() {
        return classrooms.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return classrooms.get(i).students.size();
    }

    @Override
    public Object getGroup(int i) {
        return classrooms.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return classrooms.get(i).students.get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        Classroom classroom = (Classroom) getGroup(i);
        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.classroom_item, null);
        }
        TextView order = (TextView) view.findViewById(R.id.tv_classroom_order);
        TextView number = (TextView) view.findViewById(R.id.tv_classroom_number);
        order.setText(String.valueOf(classroom.order));
        number.setText(String.valueOf(classroom.numberOfStudents));
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        Classroom.Student student = (Classroom.Student) getChild(i, i1);
        if (view == null) {
            view = activity.getLayoutInflater().inflate(R.layout.student_item, null);
        }
        TextView name = (TextView) view.findViewById(R.id.tv_student_name);
        TextView number = (TextView) view.findViewById(R.id.tv_student_number);
        name.setText(student.name);
        number.setText(String.valueOf(student.number));
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
