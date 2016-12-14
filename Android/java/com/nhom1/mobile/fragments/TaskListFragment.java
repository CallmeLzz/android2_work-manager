package com.nhom1.mobile.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nhom1.mobile.R;
import com.nhom1.mobile.activity.TaskActivity;
import com.nhom1.mobile.core.TaskAdapter;
import com.nhom1.mobile.core.TaskManager;

public class TaskListFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemClickListener {

    public TaskListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    private TaskManager taskManager;
    private Button btnLoad;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasklist, container, false);

        taskManager = TaskManager.parseJSON(getArguments().getString("JSONData"));
        TaskAdapter adapter = new TaskAdapter(getActivity(), R.layout.task_item, taskManager.getTasks());

        ListView lstTask = (ListView) view.findViewById(R.id.lstTasks);
        lstTask.setOnItemClickListener(this);
        lstTask.setAdapter(adapter);

        return view;
    }

    @Override
    public void onClick(View sender) {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ((TaskActivity) getActivity()).openTask(i, taskManager.getTasks().get(i));
    }
}