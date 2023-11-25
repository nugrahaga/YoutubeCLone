package com.example.youtubeclone.model;

import java.util.List;

import lombok.Data;

@Data
public class YoutubeResponse {

    private List<YoutubeVideos> items;

    public List<YoutubeVideos> getItems() {
        return items;
    }

    public void setItems(List<YoutubeVideos> items) {
        this.items = items;
    }
}
