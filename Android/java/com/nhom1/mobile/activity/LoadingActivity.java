package com.nhom1.mobile.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.nhom1.mobile.R;
import com.nhom1.mobile.core.TaskAPI;
import java.net.URL;

public class LoadingActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        ((Button) findViewById(R.id.btnReload)).setOnClickListener(this);

        loadTasks();
    }

    private void loadTasks()
    {
        TaskAPI task = new TaskAPI(this, findViewById(R.id.activity_loading) );
        try {
            task.execute(new URL[] { new URL("https://wm.geevoo.com/tasks/0986388066") });
        }
        catch (Exception E) {}
    }

    @Override
    public void onClick(View sender) {
        switch (sender.getId())
        {
            case R.id.btnReload:
            {
                ((Button) findViewById(R.id.btnReload)).setVisibility(View.INVISIBLE);
                loadTasks();
                break;
            }
        }
    }
}
