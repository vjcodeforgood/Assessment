package com.assignment.myapplication;

import android.app.Application;

import com.assignment.myapplication.issues.IssuesViewModel;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class IssuesViewModelTest {

    @Mock
    private Application application;
    private IssuesViewModel issuesViewModel;

    @Before
    public void initMocks() {
        issuesViewModel = new IssuesViewModel(application);
    }

    @Test
    public void loadIssues(){
        issuesViewModel.loadIssues();
    }


}
