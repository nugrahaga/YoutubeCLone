package com.example.youtubeclone.data.repository;

import static com.example.youtubeclone.utils.Constants.DETAILS;
import static com.example.youtubeclone.utils.Constants.KEY;
import static com.example.youtubeclone.utils.Constants.MOST_POPULAR;
import static com.example.youtubeclone.utils.Constants.REGION_CODE;
import static com.example.youtubeclone.utils.Constants.SNIPPET;
import static com.example.youtubeclone.utils.Constants.STATISTICS;

import com.example.youtubeclone.data.source.remote.YoutubeAPI;
import com.example.youtubeclone.model.YoutubeResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class FetchVideosRepository {

    private final YoutubeAPI youtubeAPI;

    @Inject
    public FetchVideosRepository(YoutubeAPI youtubeAPI) {
        this.youtubeAPI = youtubeAPI;
    }

    public Call<YoutubeResponse> getPopularVideos() {
        return youtubeAPI.getVideos(SNIPPET+","+DETAILS+","+STATISTICS, MOST_POPULAR, REGION_CODE, KEY);
    }
}
