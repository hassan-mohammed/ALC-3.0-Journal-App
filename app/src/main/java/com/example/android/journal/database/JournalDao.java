package com.example.android.journal.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by 0xhassan on 7/1/2018.
 */
@Dao
public interface JournalDao {


    @Query("SELECT * FROM journal ORDER BY date")
    List<JournalEntry> loadAllTasks();

    @Insert
    void insertTask(JournalEntry journalEntry);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void updateTask(JournalEntry journalEntry);

    @Delete
    void deleteTask(JournalEntry journalEntry);

}


