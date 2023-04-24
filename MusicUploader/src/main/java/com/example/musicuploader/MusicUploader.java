package com.example.musicuploader;


import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



    public class MusicUploader implements MusicUploadListener{
        private MusicUploadApi musicUploadApi;
        public static final String BASE_URL = "http://example.com/api/";



    public MusicUploader() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MusicUploader.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        musicUploadApi = retrofit.create(MusicUploadApi.class);
    }

    public void uploadMusic(String filePath, Callback<ResponseBody> callback) {
        // Create a file object from the file path
        File file = new File(filePath);

        // Create a multipart request body with the file and the file name
        RequestBody fileRequestBody = RequestBody.create(MediaType.parse("audio/mpeg"), file);
        MultipartBody.Part filePart = MultipartBody.Part.createFormData("file", file.getName(), fileRequestBody);

        // Make the API call and handle the response
        Call<ResponseBody> call = musicUploadApi.uploadMusic(filePart);
        call.enqueue(callback);
    }

        @Override
        public void onUploadStarted() {

        }

        @Override
        public void onUploadProgress(int progress) {

        }

        @Override
        public void onUploadCompleted(String response) {

        }

        @Override
        public void onUploadError(String errorMessage) {

        }
    }
