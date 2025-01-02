package com.arashivision.sdk.demo.model;

public class CameraFile {

    private String fileName;
    private boolean isVideo;

    public CameraFile(String fileName, boolean isVideo) {
        this.fileName = fileName;
        this.isVideo = isVideo;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isVideo() {
        return isVideo;
    }
}