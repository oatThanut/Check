package com.finalproject.softspec.check.addTask;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private User user;
    private EditText taskName;
    private Group group;
    private int date_x, month_x, year_x, minute_x, hour_x;
    private final int DATE_DIALOG_ID = 0;
    private final int TIME_DIALOG_ID = 1;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        final Calendar cal = Calendar.getInstance();
        year_x = cal.get(Calendar.YEAR);
        month_x = cal.get(Calendar.MONTH);
        date_x = cal.get(Calendar.DAY_OF_MONTH);

        user = User.getInstance();
        Group groupTemp = getIntent().getParcelableExtra("group");
        if(groupTemp!=null) {
            int groupID = groupTemp.getId();
            for (Group a : user.getGroupList()) {
                if (a.getId() == groupID) group = a;
            }
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskName = (EditText) findViewById(R.id.taskName);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(group == null) {
                    System.out.println(">>>>"+ taskName.getText().toString());
                    user.addTask(new Task(taskName.getText().toString(), date_x, month_x, year_x, minute_x, hour_x));
                    onBackPressed();
                } else {
                    group.addTask(new Task(taskName.getText().toString(), date_x, month_x, year_x, minute_x, hour_x));
                    onBackPressed();
                }
            }
        });

        findViewById(R.id.setDateBtn).setOnClickListener(this);
        findViewById(R.id.setTimeBtn).setOnClickListener(this);
    }

    @Override
    protected Dialog onCreateDialog(int id) {
         if(id == DATE_DIALOG_ID) {
            return new DatePickerDialog(this, dpickerListener, year_x, month_x, date_x);
         } else if (id == TIME_DIALOG_ID) {
            return new TimePickerDialog(this, tpickerListener, minute_x, hour_x, false);
         }
         return null;
    }

    private TimePickerDialog.OnTimeSetListener tpickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            minute_x = minute;
            hour_x = hourOfDay;
            Toast.makeText(AddTaskActivity.this, hour_x +":"+minute_x,Toast.LENGTH_LONG).show();
        }
    };

    private DatePickerDialog.OnDateSetListener  dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month + 1;
            date_x = dayOfMonth;
            Toast.makeText(AddTaskActivity.this, year_x +"/"+month_x+"/"+date_x,Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.setDateBtn) {
            showDialog(DATE_DIALOG_ID);
        } else if(i == R.id.setTimeBtn) {
            showDialog(TIME_DIALOG_ID);
        }
    }
}
