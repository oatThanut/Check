package com.finalproject.softspec.check.addTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

public class EditTaskActivity extends AppCompatActivity implements View.OnClickListener {

    private User user;
    private Task task;
    private Group group;
    private EditText name;

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
    }

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
        onBackPressed();
    }
}
