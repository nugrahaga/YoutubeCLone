package com.example.youtubeclone.data.repository;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HomeVideoData {
    private String videoTitle;

    private String videoDetail;

    public HomeVideoData(String videoTitle, String videoDetail) {
        this.videoTitle = videoTitle;
        this.videoDetail = videoDetail;
    }

    public String getVideoTitle() {
        return videoTitle;
    }

    public String getVideoDetail() {
        return videoDetail;
    }
}
