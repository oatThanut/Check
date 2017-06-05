package com.finalproject.softspec.check.homeScreen;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.finalproject.softspec.check.MainActivity;
import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.addTask.AddTaskActivity;
import com.finalproject.softspec.check.addTask.EditTaskActivity;
import com.finalproject.softspec.check.groupScreen.GroupListActivity;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private View view;
    private User user;
    private ListView listView;
    private ArrayAdapter<Task> adapter;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Home");
        user = User.getInstance();

        view =  inflater.inflate(R.layout.home_add_task, container, false);

        updateList();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), AddTaskActivity.class);
                startActivityForResult(intent, 0);
            }
        });

        return view;
    }

    public void updateList() {
        listView = (ListView) view.findViewById(R.id.listView);
        adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, user.getPrimaryList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), EditTaskActivity.class);
                intent.putExtra("task", (Task)listView.getItemAtPosition(position));
                startActivityForResult(intent, 0);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        updateList();
    }
}
