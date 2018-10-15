package com.example.amirahmadadibi.myapplication.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.amirahmadadibi.myapplication.database.NoteEntity;
import com.example.amirahmadadibi.myapplication.utilities.SampleData;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    public List<NoteEntity> mNotes = SampleData.getNotes();
    public MainViewModel(@NonNull Application application) {
        super(application);
    }

}
