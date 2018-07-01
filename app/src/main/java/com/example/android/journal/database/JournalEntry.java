package com.example.android.journal.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import java.util.Date;

/**
 * Created by 0xhassan on 7/1/2018.
 */
@Entity(tableName = "Journal")
public class JournalEntry {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String description;
    private String title;
    private Date date;


    @Ignore
    public JournalEntry(  String title,String description, Date date) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.date = date;
    }


    public JournalEntry(int id, String title, String description, Date date) {
        this.id = id;
        this.description = description;
        this.title = title;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
