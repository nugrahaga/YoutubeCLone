package com.example.youtubeclone.model;

import lombok.Data;

@Data
public class YoutubeVideos {

    private String id;
    private VideoDetails snippet;
    private ContentDetails contentDetails;
    private VideoStats statistics;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VideoDetails getSnippet() {
        return snippet;
    }

    public void setSnippet(VideoDetails snippet) {
        this.snippet = snippet;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public void setContentDetails(ContentDetails contentDetails) {
        this.contentDetails = contentDetails;
    }

    public VideoStats getStatistics() {
        return statistics;
    }

    public void setStatistics(VideoStats statistics) {
        this.statistics = statistics;
    }
}
