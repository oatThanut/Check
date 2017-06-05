package com.finalproject.softspec.check.profileScreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.finalproject.softspec.check.R;
import com.finalproject.softspec.check.model.User;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    private TextView completed;
    private TextView overdue;
    private TextView name;
    private User user;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        getActivity().setTitle("Profile");

        user = User.getInstance();


        View view =  inflater.inflate(R.layout.fragment_profile, container, false);
        name = (TextView) view.findViewById(R.id.nameTextView);
        completed = (TextView) view.findViewById(R.id.CompletedNum);
        overdue = (TextView) view.findViewById(R.id.OverdueNum);

        name.setText(user.getName().toString());
        completed.setText(user.getCompleted()+"");
        overdue.setText(user.getOverdue()+"");
        return view;
    }

}
