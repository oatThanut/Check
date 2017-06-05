package com.finalproject.softspec.check.addTask;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

public class AddTaskActivity extends AppCompatActivity {

    private User user;
    private EditText taskName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        user = User.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        taskName = (EditText) findViewById(R.id.taskName);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                System.out.println(">>>>"+ taskName.getText().toString());
                user.addTask(new Task(taskName.getText().toString()));
                onBackPressed();
            }
        });
    }

}
