package com.assignment.myapplication.model;

import android.content.Context;
import android.os.AsyncTask;

import com.assignment.myapplication.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IssueAsync extends AsyncTask<Void,Void, Void> {

    private AsyncCallback<List<Issue>> listAsyncCallback;
    private Context mContext;
    private Exception exception;
    private List<Issue> issues = new ArrayList<>();


    public IssueAsync(AsyncCallback<List<Issue>> listAsyncCallback, Context mContext) {
        this.listAsyncCallback = listAsyncCallback;
        this.mContext = mContext;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        //read raw file
        InputStream inputStream = mContext.getResources().openRawResource(R.raw.issues);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine;
            //skip header
            reader.readLine();
            while ((csvLine = reader.readLine()) != null) {
                String[] row = csvLine.split(",");
                Issue issue = new Issue();
                issue.setFirst_name(row[0].substring(1,row[0].length()-1));
                issue.setSur_name(row[1].substring(1,row[1].length()-1));
                issue.setIssue_count(Integer.parseInt((row[2])));
                issue.setDob(row[3].substring(1,row[3].length()-1));
                issues.add(issue);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //return issues;
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        listAsyncCallback.onSuccess(issues);
    }
}
