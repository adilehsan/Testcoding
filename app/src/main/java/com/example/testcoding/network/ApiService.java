package com.example.testcoding.network;

import com.example.testcoding.model.ImagesItemModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("/photos")
    Call<List<ImagesItemModel>> getAllPhotos();
}
