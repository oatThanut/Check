package com.finalproject.softspec.check.addTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

public class AddTaskActivity extends AppCompatActivity {

    private User user;
    private EditText taskName;
    private Group group;
    private String groupID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

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
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                if(group == null) {
                    System.out.println(">>>>"+ taskName.getText().toString());
                    user.addTask(new Task(taskName.getText().toString()));
                    onBackPressed();
                } else {
                    group.addTask(new Task(taskName.getText().toString()));
                    onBackPressed();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
//        if (group != null) {
//            Intent returnedIntent = new Intent();
//            returnedIntent.putExtra("group", group);
//            setResult(Activity.RESULT_OK, returnedIntent);
//        }
        super.onBackPressed();
    }
}
