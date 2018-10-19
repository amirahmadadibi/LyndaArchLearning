package com.example.amirahmadadibi.myapplication.database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

//it defines all of operations we want to execute with particular data set
@Dao
public interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(NoteEntity noteEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] insertAll(List<NoteEntity> noteEntitys);

    @Delete
    void deleteNote(NoteEntity noteEntity);

    @Query("select * from notes Where id = :id")
    NoteEntity getNoteById(int id);


    @Query("select * from notes order by date desc")
    LiveData<List<NoteEntity>> getAll();

    @Query("delete  from notes")
    int deleteAll();

    @Query("select count(*) from notes")
    int getCount();
}
