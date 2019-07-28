package com.example.testcoding.roomdb;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.testcoding.roomdb.dbtables.RetroImagesTable;

@Database(entities = {RetroImagesTable.class}, version = 1)
public abstract class RoomImagesDatabase extends RoomDatabase {
    public abstract RoomDao Dao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile RoomImagesDatabase INSTANCE;

    public static RoomImagesDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (RoomImagesDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            RoomImagesDatabase.class, "images_database")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
