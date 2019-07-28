package com.example.testcoding.roomdb.dbrepository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.testcoding.roomdb.RoomDao;
import com.example.testcoding.roomdb.RoomImagesDatabase;
import com.example.testcoding.roomdb.dbtables.RetroImagesTable;

import java.util.List;

public class ImagesDbRepository {
    private RoomDao mDao;
    private LiveData<List<RetroImagesTable>> mAllImages;

    public ImagesDbRepository(Application application){
        RoomImagesDatabase db = RoomImagesDatabase.getDatabase(application);
        mDao = db.Dao();
        mAllImages = mDao.getAllImages();

    }
    public LiveData<List<RetroImagesTable>> getAllImages() {
        return mAllImages;
    }

    public void insertAllImages(RetroImagesTable collectionsTable){
        new ImagesDbRepository.insertAsynTask(mDao).execute(collectionsTable);
    }

    public static class insertAsynTask extends AsyncTask<RetroImagesTable,Void,Void> {
        private RoomDao mAsyncTaskDao;

        insertAsynTask(RoomDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final RetroImagesTable... params) {
            mAsyncTaskDao.insertImages(params[0]);
            return null;
        }
    }
}
