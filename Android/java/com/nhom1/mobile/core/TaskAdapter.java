package com.nhom1.mobile.core;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.nhom1.mobile.R;
import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Activity context = null;
    private ArrayList<Task> taskList = null;
    private int layoutId;

    public TaskAdapter(Activity context, int layoutId, ArrayList<Task> TaskList){
        super(context, layoutId, TaskList);
        this.context = context;
        this.layoutId = layoutId;
        this.taskList = TaskList;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(layoutId, null);
        if ((position >= 0) && (position < taskList.size()))
        {
            Task task = taskList.get(position);
            TextView txtTitle = (TextView) convertView.findViewById(R.id.item_title);
            txtTitle.setText(task.getTitle());
            TextView txtTeam = (TextView) convertView.findViewById(R.id.item_team);
            txtTeam.setText(task.getTeam());
        }
        return convertView;
    }
}
