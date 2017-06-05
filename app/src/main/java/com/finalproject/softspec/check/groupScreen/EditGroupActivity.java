package com.finalproject.softspec.check.groupScreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.User;

public class EditGroupActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private User user;
    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);

        user = User.getInstance();

        Group groupTemp = getIntent().getParcelableExtra("group");
        int groupID = groupTemp.getId();
        for(Group a : user.getGroupList()) {
            if(a.getId() == groupID) group = a;
        }

        findViewById(R.id.saveBtn).setOnClickListener(this);
        findViewById(R.id.deleteBtn).setOnClickListener(this);
        name = (EditText) findViewById(R.id.nameEditText);
        name.setText(group.getName());
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.saveBtn) {
            group.setName(name.getText().toString());
            onBackPressed();
        } else if(i == R.id.deleteBtn) {
            user.deleteGroup(group.getId());
            onBackPressed();
        }
    }
}
