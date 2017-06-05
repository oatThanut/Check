package com.finalproject.softspec.check.groupScreen;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Group;
import com.finalproject.softspec.check.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class GroupFragment extends Fragment {

    private View view;
    private User user;
    private ListView listView;
    private ArrayAdapter<Group> adapter;

    public GroupFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Group");
        user = User.getInstance();
        view = inflater.inflate(R.layout.group_add_group, container, false);

        updateList();

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO impliment to be add task button
//                Snackbar.make(view, "In group", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getActivity(), AddGroupActivity.class);
//                personIntent.putExtra("user", user);
                startActivityForResult(intent, 0);
            }
        });
        return view;
    }

    public void updateList() {
        listView = (ListView) view.findViewById(R.id.groupList);
        adapter = new ArrayAdapter<Group>(getActivity(),
                android.R.layout.simple_list_item_1, user.getGroupList());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), GroupListActivity.class);
                intent.putExtra("group", (Group) listView.getItemAtPosition(position));
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
