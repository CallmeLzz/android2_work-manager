package com.nhom1.mobile.core;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.nhom1.mobile.R;
import com.nhom1.mobile.activity.TaskActivity;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class TaskAPI extends AsyncTask<URL, Void, String> {
    private Context fContext;
    private View fView;
    public TaskAPI(Context context, View view) {
        this.fContext = context;
        this.fView = view;

        ((ProgressBar) fView.findViewById(R.id.prgLoading)).setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(URL... urls) {
        String responseString = "";
        try
        {
            URLConnection urlConnect = urls[0].openConnection();
            BufferedReader responseStream = new BufferedReader(new InputStreamReader(urlConnect.getInputStream()));

            StringBuilder stringBuilder = new StringBuilder();
            String lineString;
            while ((lineString = responseStream.readLine()) != null)
                stringBuilder.append(lineString + "\n");
            responseStream.close();
            responseString = stringBuilder.toString();
        }
        catch (Exception E) { }

        return responseString;
    }

    private boolean checkSuccess(String responseString)
    {
        try {
            JSONObject jObject = new JSONObject(responseString);
            return  jObject.getBoolean("status");
        }
        catch (Exception E) { return false; }
    }

    @Override
    protected void onPostExecute(String responseString)
    {
        ((ProgressBar) fView.findViewById(R.id.prgLoading)).setVisibility(View.INVISIBLE);
        if (checkSuccess(responseString))
        {
            ((Button) fView.findViewById(R.id.btnReload)).setVisibility(View.INVISIBLE);
            Intent intent = new Intent(fContext, TaskActivity.class);
            intent.putExtra("JSONData", responseString);
            fContext.startActivity(intent);
        }
        else
        {
            ((Button) fView.findViewById(R.id.btnReload)).setVisibility(View.VISIBLE);
        }
        super.onPostExecute(responseString);
    }
}
