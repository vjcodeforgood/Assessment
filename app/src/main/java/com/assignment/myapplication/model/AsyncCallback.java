package com.assignment.myapplication.model;

public interface AsyncCallback<T> {
    public void onSuccess(T listOfIssues);
    public void onFailure(Exception e);
}
