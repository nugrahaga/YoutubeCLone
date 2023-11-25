package com.example.youtubeclone.model;

import lombok.Data;

@Data
public class ThumbnailAtrributes {

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
