package com.example.testcoding.repositories;

import android.arch.lifecycle.MutableLiveData;

import com.example.testcoding.model.ImagesItemModel;
import com.example.testcoding.network.ApiService;
import com.example.testcoding.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroImagesRepository {
    public static RetroImagesRepository allImagesRepo;

    public static RetroImagesRepository getAllImagesRepo() {
        if (allImagesRepo == null) {
            allImagesRepo = new RetroImagesRepository();
        }
        return allImagesRepo;
    }

    private ApiService apiService;

    public RetroImagesRepository() {
        apiService = RetrofitClient.getRetrofitInstance().create(ApiService.class);
    }

    public MutableLiveData<List<ImagesItemModel>> getAllDummyImages() {
        final MutableLiveData<List<ImagesItemModel>> mutableLiveData = new MutableLiveData<>();
        Call<List<ImagesItemModel>> listCall = apiService.getAllPhotos();
        listCall.enqueue(new Callback<List<ImagesItemModel>>() {
            @Override
            public void onResponse(Call<List<ImagesItemModel>> call, Response<List<ImagesItemModel>> response) {
                mutableLiveData.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<ImagesItemModel>> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }
}
