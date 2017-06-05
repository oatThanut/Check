package com.finalproject.softspec.check;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.finalproject.softspec.check.addTask.EditTaskActivity;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        findViewById(R.id.signInButton).setOnClickListener(this);
        findViewById(R.id.join).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if(i == R.id.signInButton) {
            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        } else if(i == R.id.join) {
            Toast.makeText(SignUpActivity.this, "Just mock bro, sorry",Toast.LENGTH_LONG).show();
        }
    }
}
