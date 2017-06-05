package com.finalproject.softspec.check.groupScreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.addTask.AddTaskActivity;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

public class GroupListActivity extends AppCompatActivity {

    private User user;
    private Group group;
    private TextView groupName;
    private ListView listView;
    private ArrayAdapter<Task> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        user = User.getInstance();

        Group groupTemp = getIntent().getParcelableExtra("group");
        int groupID = groupTemp.getId();
        for(Group a : user.getGroupList()) {
            if(a.getId() == groupID) group = a;
        }
        groupName = (TextView) findViewById(R.id.groupName);
        groupName.setText(group.getName());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(GroupListActivity.this, AddTaskActivity.class);
                intent.putExtra("group", group);
                startActivityForResult(intent, 0);
            }
        });


        updateList();
    }

    public void updateList() {
        listView = (ListView) findViewById(R.id.list);
        adapter = new ArrayAdapter<Task>(this,
                android.R.layout.simple_list_item_1, group.getList());
        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(getActivity(), GroupListActivity.class);
//                intent.putExtra("group", (Group) listView.getItemAtPosition(position));
//                startActivityForResult(intent, 0);
//            }
//        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_action_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit:
                Intent personIntent = new Intent(GroupListActivity.this, EditGroupActivity.class);
                personIntent.putExtra("group", group);
                startActivityForResult(personIntent, 0);
                return true;
            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        groupName.setText(group.getName());
        updateList();
    }
}
