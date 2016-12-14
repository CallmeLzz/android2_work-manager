package com.nhom1.mobile.core;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class TaskManager {
    public TaskManager(boolean Status) {
        this.fStatus = Status;
        this.fTasks = new ArrayList<Task>();
    }

    public TaskManager() {
        this.fStatus = false;
        this.fTasks = new ArrayList<Task>();
    }

    public boolean getStatus() {
        return fStatus;
    }

    public void setStatus(boolean Status) {
        this.fStatus = Status;
    }

    public ArrayList<Task> getTasks() {
        return fTasks;
    }

    public void setTasks(ArrayList<Task> Tasks) {
        this.fTasks = Tasks;
    }

    private boolean fStatus;
    private ArrayList<Task> fTasks;

    public static TaskManager parseJSON(String JSONString)
    {
        TaskManager taskManager = new TaskManager();
        try
        {
            JSONObject jObject = new JSONObject(JSONString);
            taskManager.setStatus(jObject.getBoolean("status"));

            JSONArray jTasks = jObject.getJSONArray("tasks");
            for (int i = 0 ; i < jTasks.length(); i++)
            {
                Task task = new Task();
                try {

                    JSONObject jTask = jTasks.getJSONObject(i);
                    task.setId(jTask.getInt("id"));
                    task.setTitle(jTask.getString("name"));
                    task.setDescript(jTask.getString("descript"));
                    task.setTeam(jTask.getString("team"));
                    task.setBegin(jTask.getString("begin"));
                    task.setEnd(jTask.getString("end"));
                    taskManager.getTasks().add(task);
                }
                catch (Exception e) {}
            }
        }
        catch (Exception E) {}

        return taskManager;
    }
}
