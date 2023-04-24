package com.example.musicuploader;

public interface MusicUploadListener {
    void onUploadStarted();
    void onUploadProgress(int progress);
    void onUploadCompleted(String response);
    void onUploadError(String errorMessage);
}
