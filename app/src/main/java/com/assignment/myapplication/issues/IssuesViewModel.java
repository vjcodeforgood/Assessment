package com.assignment.myapplication.issues;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.assignment.myapplication.model.AsyncCallback;
import com.assignment.myapplication.model.Issue;
import com.assignment.myapplication.model.IssueAsync;

import java.util.List;

public class IssuesViewModel extends AndroidViewModel {

    private MutableLiveData<List<Issue>> issueList;

    public IssuesViewModel(@NonNull Application application) {
        super(application);
    }


    public LiveData<List<Issue>> getIssues() {
        if(issueList == null){
            loadIssues();
        }
        return issueList;
    }

    public void loadIssues() {
        issueList = new MutableLiveData<>();
        IssueAsync issueAsync = new IssueAsync(new AsyncCallback<List<Issue>>() {
            @Override
            public void onSuccess(List<Issue> listOfIssues) {
                issueList.postValue(listOfIssues);
            }

            @Override
            public void onFailure(Exception e) {
            }
        },getApplication());

        issueAsync.execute();
    }
}
