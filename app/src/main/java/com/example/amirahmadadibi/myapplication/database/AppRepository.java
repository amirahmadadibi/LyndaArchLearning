package com.example.amirahmadadibi.myapplication.database;

import android.content.Context;
import android.util.Log;

import com.example.amirahmadadibi.myapplication.utilities.SampleData;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static AppRepository ourInstance;
    public List<NoteEntity> mNotes;
    private AppDatabase mDb;
    private Executor executor = Executors.newSingleThreadExecutor();

    public static AppRepository getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new AppRepository(context);
        }
        return ourInstance;
    }

    private AppRepository(Context context) {
        mNotes = SampleData.getNotes();
        mDb = AppDatabase.getInstance(context);
    }

    public void addSampleData() {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Long[] noteEntities = mDb.noteDao().insertAll(SampleData.getNotes());
                for (Long noteEn : noteEntities) {
                    Log.d("db", "run: all data added : *** " + noteEn);
                }
            }
        });
    }
}
