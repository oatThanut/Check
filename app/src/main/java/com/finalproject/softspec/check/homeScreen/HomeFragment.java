package com.finalproject.softspec.check.homeScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.Task;
import com.finalproject.softspec.check.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

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

        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        listView = (ListView) view.findViewById(R.id.listView);
        adapter = new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, user.getPrimaryList());
        listView.setAdapter(adapter);

        return view;
    }

}
