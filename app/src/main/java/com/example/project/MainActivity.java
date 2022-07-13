package com.example.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ms.square.android.expandabletextview.ExpandableTextView;

public class MainActivity extends AppCompatActivity {
    CardView lectures, syllabus, timetable, contactus, translate, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getAttributes().windowAnimations = R.style.Fade;
        getSupportActionBar().hide();
        lectures = (CardView) findViewById(R.id.lectures);
        syllabus = (CardView) findViewById(R.id.syllabus);
        timetable = (CardView) findViewById(R.id.timetable);
        contactus = (CardView) findViewById(R.id.contactus);
        translate = (CardView) findViewById(R.id.translate);
        result = (CardView) findViewById(R.id.result);

        lectures.setOnClickListener(this::onClick);
        syllabus.setOnClickListener(this::onClick);
        timetable.setOnClickListener(this::onClick);
        contactus.setOnClickListener(this::onClick);
        translate.setOnClickListener(this::onClick);
        result.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.lectures:
                i = new Intent(this, LectureClass.class);
                startActivity(i);
                finish();
                break;
            case R.id.syllabus:
                i = new Intent(this, SyllabusClass.class);
                startActivity(i);
                finish();
                break;
            case R.id.timetable:
                i = new Intent(this, TimetableClass.class);
                startActivity(i);
                finish();
                break;
            case R.id.contactus:
                i = new Intent(this, ContactUs.class);
                startActivity(i);
                finish();
                break;
            case R.id.translate:
                i = new Intent(this, Translate.class);
                startActivity(i);
                finish();
                break;
            case R.id.result:
                i = new Intent(this, Result.class);
                startActivity(i);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.ic_baseline_warning_24).setTitle("Sure Exit!").setMessage("Press YES to exit")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        }).show();
    }
}