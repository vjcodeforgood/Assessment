package com.assignment.myapplication.issues;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.myapplication.R;
import com.assignment.myapplication.model.Issue;

import java.util.List;

public class IssuesAdaptor extends RecyclerView.Adapter<IssuesAdaptor.IssueViewHolder> {

    private Context context;
    private List<Issue> issues;

    public IssuesAdaptor(Context context, List<Issue> issues) {
        this.context = context;
        this.issues = issues;
    }

    @NonNull
    @Override
    public IssueViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.issues_layout, parent, false);
        return new IssueViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull IssueViewHolder holder, int position) {

        Issue issue = issues.get(position);

        holder.first_name.setText(issue.getFirst_name());
        holder.sur_name.setText(issue.getSur_name());
        holder.issue_count.setText(String.valueOf(issue.getIssue_count()));
        holder.dob.setText(issue.getDob());

    }

    @Override
    public int getItemCount() {
        return issues.size();
    }

    public class IssueViewHolder extends RecyclerView.ViewHolder {

        TextView first_name, sur_name, issue_count, dob;

        public IssueViewHolder(@NonNull View itemView) {
            super(itemView);

            first_name = itemView.findViewById(R.id.firstname);
            sur_name = itemView.findViewById(R.id.surname);
            issue_count = itemView.findViewById(R.id.issues);
            dob = itemView.findViewById(R.id.dob);
        }
    }
}
