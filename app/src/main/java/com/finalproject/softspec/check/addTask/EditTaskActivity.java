package com.finalproject.softspec.check.addTask;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

public class EditTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private User user;
    private Task task;
    private Group group;
    private EditText name;
    private int date_x, month_x, year_x, minute_x, hour_x;
    private final int DATE_DIALOG_ID = 0;
    private final int TIME_DIALOG_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        user = User.getInstance();

        task = getIntent().getParcelableExtra("task");

        Group groupTemp = getIntent().getParcelableExtra("group");
        if(groupTemp!=null) {
            int groupID = groupTemp.getId();
            for (Group a : user.getGroupList()) {
                if (a.getId() == groupID) group = a;
            }
        }

        name = (EditText) findViewById(R.id.nameEditText);
        name.setText(task.getName());

        findViewById(R.id.saveBtn).setOnClickListener(this);
        findViewById(R.id.deleteBtn).setOnClickListener(this);
        findViewById(R.id.completeBtn).setOnClickListener(this);
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
            Toast.makeText(EditTaskActivity.this, hour_x +":"+minute_x,Toast.LENGTH_LONG).show();
        }
    };

    private DatePickerDialog.OnDateSetListener  dpickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            year_x = year;
            month_x = month + 1;
            date_x = dayOfMonth;
            Toast.makeText(EditTaskActivity.this, year_x +"/"+month_x+"/"+date_x,Toast.LENGTH_LONG).show();

        }
    };

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(group == null){
            if (i == R.id.saveBtn) {
                user.changePTask(task.getId(), name.getText().toString());
            } else if(i == R.id.deleteBtn) {
                user.deletePTask(task.getId());
            } else if(i == R.id.completeBtn) {
                user.completePTask(task.getId());
            }
        } else {
            if (i == R.id.saveBtn) {
                user.changeGTask(task.getId(), group.getId(), name.getText().toString());
            } else if(i == R.id.deleteBtn) {
                user.deleteGTask(task.getId(), group.getId());
            } else if(i == R.id.completeBtn) {
                user.completeGTask(task.getId(), group.getId());
            }
        }
        if(i == R.id.setDateBtn) {
            showDialog(DATE_DIALOG_ID);
        } else if(i == R.id.setTimeBtn) {
            showDialog(TIME_DIALOG_ID);
        }
        onBackPressed();
    }
}
