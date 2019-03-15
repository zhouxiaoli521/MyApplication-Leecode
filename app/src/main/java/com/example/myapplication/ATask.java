package com.example.myapplication;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class ATask extends AsyncTask <Integer,Integer,String> {
    Button activity;

    public ATask(Button ac) {
        activity=ac;
    }

    @Override
    protected String doInBackground(Integer[] objects) {
        for(int i=0;i<50;i++){
            try {
                Thread.sleep(100);
                publishProgress(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "doInBackground";
    }

    @Override
    protected void onPostExecute(String o) {
        activity.setText("onPostExecute"+" "+o);
    }


    @Override
    protected void onPreExecute() {
        activity.setText("onPreExecute");
    }

    @Override
    protected void onProgressUpdate(Integer[] values) {
        activity.setText(""+values[0]);
    }


    @Override
    protected void onCancelled() {
    }
}
