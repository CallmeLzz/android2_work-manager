package com.nhom1.mobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.nhom1.mobile.R;

public class DetailFragment extends Fragment{

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle bundle = getArguments();
        String taskInfo = "Title: \n    " + bundle.getString("Title") + "\n";
        taskInfo += "Description: \n    " + bundle.getString("Descript") + "\n";
        taskInfo += "Team: \n    " + bundle.getString("Team") + "\n";
        taskInfo += "Begin: \n    " + bundle.getString("Begin") + "\n";
        taskInfo += "End: \n    " + bundle.getString("End") + "\n";

        ((EditText) view.findViewById(R.id.edtDetail)).setText(taskInfo);
        return view;
    }
}