package com.example.testcoding.roomdb.dbtables;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "images_table")
public class RetroImagesTable {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String ID;

    @NonNull
    @ColumnInfo(name = "albumId")
    private String albumId;

    @NonNull
    @ColumnInfo(name = "title")
    private String title;

    @NonNull
    @ColumnInfo(name = "url")
    private String UrlImages;

    @NonNull
    @ColumnInfo(name = "thumbnailUrl")
    private String thumbnailUrl;

    @NonNull
    public String getID() {
        return ID;
    }

    public void setID(@NonNull String ID) {
        this.ID = ID;
    }

    @NonNull
    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(@NonNull String albumId) {
        this.albumId = albumId;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    @NonNull
    public String getUrlImages() {
        return UrlImages;
    }

    public void setUrlImages(@NonNull String urlImages) {
        UrlImages = urlImages;
    }

    @NonNull
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(@NonNull String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
