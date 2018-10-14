package com.example.amirahmadadibi.myapplication;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.amirahmadadibi.myapplication.database.AppDatabase;
import com.example.amirahmadadibi.myapplication.database.NoteDao;
import com.example.amirahmadadibi.myapplication.utilities.SampleData;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {
    public static final String TAG = "junit";
    private AppDatabase mDb;
    private NoteDao mDao;

    @Before
    public void createDb() {
        Context context = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        mDao = mDb.noteDao();
        Log.i(TAG, "carete dabase");
    }

    @After
    public void closeDb() {
        mDb.close();
        Log.i(TAG, "closeDb");
    }

    @Test
    public void createAndRetrieveNotes() {
        mDao.insertAll(SampleData.getNotes());
        int count = mDao.getCount();
        Log.i(TAG, "count of rows : " + count);
        assertEquals(SampleData.getNotes().size(), count);
    }

}
