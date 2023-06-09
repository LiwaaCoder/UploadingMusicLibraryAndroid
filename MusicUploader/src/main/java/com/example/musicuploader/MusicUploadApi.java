package com.example.musicuploader;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface MusicUploadApi {

    @Multipart
    @POST("/upload")
    Call<ResponseBody> uploadMusic(@Part MultipartBody.Part file);

}



