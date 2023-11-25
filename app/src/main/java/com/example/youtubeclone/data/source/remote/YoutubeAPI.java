package com.example.youtubeclone.data.source.remote;

import static com.example.youtubeclone.utils.Constants.LIST_OF_VIDEOS;

import com.example.youtubeclone.model.YoutubeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeAPI {

    @GET(LIST_OF_VIDEOS)
    Call<YoutubeResponse> getVideos(@Query("part") String part, @Query("chart") String chart, @Query("regionCode") String regionCode, @Query("key") String key);
}
