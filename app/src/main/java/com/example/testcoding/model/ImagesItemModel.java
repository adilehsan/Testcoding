package com.example.testcoding.model;

import com.google.gson.annotations.SerializedName;

public class ImagesItemModel {
    @SerializedName("albumId")
    public String albumID;
    @SerializedName("id")
    public String id;
    @SerializedName("title")
    public String title;
    @SerializedName("url")
    public String imageUrl;
    @SerializedName("thumbnailUrl")
    public String thumbnailUrl;

    public String getAlbumID() {
        return albumID;
    }

    public void setAlbumID(String albumID) {
        this.albumID = albumID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
