package com.example.youtubeclone.model;

import lombok.Data;

@Data
public class Thumbnails {
    private ThumbnailAtrributes medium;

    public ThumbnailAtrributes getMedium() {
        return medium;
    }

    public void setMedium(ThumbnailAtrributes medium) {
        this.medium = medium;
    }
}
