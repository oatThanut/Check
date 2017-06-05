package com.finalproject.softspec.check.groupScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.User;

public class EditGroupActivity extends AppCompatActivity implements View.OnClickListener {

    private Button saveBtn;
    private Button deleteBtn;
    private EditText name;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_group);

        user = User.getInstance();

        findViewById(R.id.saveBtn).setOnClickListener(this);
        findViewById(R.id.deleteBtn).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.saveBtn) {

        } else if(i == R.id.deleteBtn) {

        }
    }
}
