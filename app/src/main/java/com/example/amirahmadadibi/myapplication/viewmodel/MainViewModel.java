package com.example.amirahmadadibi.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.amirahmadadibi.myapplication.database.AppRepository;
import com.example.amirahmadadibi.myapplication.database.NoteEntity;

import java.util.List;

//stores persistent data in memory and manages biz logic
public class MainViewModel extends AndroidViewModel {
    public List<NoteEntity> mNotes;
    private AppRepository mRepository;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mRepository = AppRepository.getInstance(application.getApplicationContext());
        mNotes = mRepository.mNotes;
    }

    public void addSampleData() {
        mRepository.addSampleData();
        Log.d("db", "run: view model call");

    }
}
