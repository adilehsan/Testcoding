package com.example.testcoding.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.testcoding.model.ImagesItemModel;
import com.example.testcoding.repositories.RetroImagesRepository;

import java.util.List;

public class RetroImagesViewModel extends ViewModel {
    private MutableLiveData<List<ImagesItemModel>> listMutableLiveData;
    private RetroImagesRepository retroImagesRepository;

    public void inIT() {
        if (retroImagesRepository != null) {
            return;
        }
        retroImagesRepository = RetroImagesRepository.getAllImagesRepo();
        listMutableLiveData = retroImagesRepository.getAllDummyImages();
    }


    public LiveData<List<ImagesItemModel>> getAllImages() {
        return listMutableLiveData;
    }
}
