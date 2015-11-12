package com.liwenxiang.demoexpandablelistview2;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liwenxiang on 2015/11/11.
 */
public class MainActivity extends AppCompatActivity {

    private SchoolAdapter schoolAdapter;
    private List<Classroom> classrooms;
    private Handler handler;
    private Runnable runnable;
    private int cnt = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        classrooms = new ArrayList<>();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.lv_school);
        schoolAdapter = new SchoolAdapter(this, classrooms);
        listView.setAdapter(schoolAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "每隔5秒减少一个班级", Toast.LENGTH_SHORT).show();
                    }
                });
                getData(--cnt);
                if (cnt > 0) {
                    handler.postDelayed(runnable, 5000);
                }
            }
        };
        handler.postDelayed(runnable, 5000);
        getData(cnt);
    }

    private void getData(int num) {
        classrooms.clear();
        for (int i = 1; i <= num; i++) {
            classrooms.add(new Classroom(i, (i+10)));
        }
        schoolAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
