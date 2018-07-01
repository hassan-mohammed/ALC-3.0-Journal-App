package com.example.android.journal.database;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by 0xhassan on 7/1/2018.
 */

public class DateConverter {

    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
