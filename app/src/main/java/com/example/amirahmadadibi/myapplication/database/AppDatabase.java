package com.example.amirahmadadibi.myapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {NoteEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "AppDatabase.db";

    //volatile objects are always in main memory
    private static volatile AppDatabase instance;
    private static Object LOCK = new Object();
    //for each dao interface we should have abstract method thar return instance of interface
    //because this method will never ba called directly, instead there will be some generated code
    //that's created by the room database in background,and that's the version of method that we calling
    public abstract NoteDao noteDao();


    //singltone pattern for saveing instace
    public static AppDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null)
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, DATABASE_NAME).build();
            }
        }
        return instance;
    }
}
