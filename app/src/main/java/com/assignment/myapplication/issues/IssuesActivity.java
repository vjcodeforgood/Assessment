package com.assignment.myapplication.issues;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.assignment.myapplication.R;
import com.assignment.myapplication.model.Issue;

import java.util.List;

public class IssuesActivity extends AppCompatActivity {

    IssuesAdaptor issuesAdaptor;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IssuesViewModel issuesViewModel = ViewModelProviders.of(this).get(IssuesViewModel.class);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        issuesViewModel.getIssues().observe(this, new Observer<List<Issue>>() {
            @Override
            public void onChanged(List<Issue> issues) {
                issuesAdaptor = new IssuesAdaptor(getApplicationContext(),issues);
                recyclerView.setAdapter(issuesAdaptor);
            }
        });
    }

}
