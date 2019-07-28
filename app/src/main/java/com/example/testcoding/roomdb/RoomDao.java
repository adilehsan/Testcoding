package com.example.testcoding.roomdb;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.testcoding.roomdb.dbtables.RetroImagesTable;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface RoomDao {

    @Insert(onConflict = REPLACE)
    void insertImages(RetroImagesTable retroImagesTable);

    @Query("SELECT * from images_table")
    LiveData<List<RetroImagesTable>> getAllImages();
}
