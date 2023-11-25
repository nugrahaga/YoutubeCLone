package com.example.youtubeclone.ui.home.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.youtubeclone.data.repository.FetchVideosRepository;
import com.example.youtubeclone.model.YoutubeResponse;
import com.example.youtubeclone.utils.NetworkHelper;
import com.example.youtubeclone.utils.Resource;

import java.util.concurrent.CompletableFuture;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final NetworkHelper networkHelper;

    private final FetchVideosRepository fetchVideosRepository;

    private final MutableLiveData<Resource<YoutubeResponse>> _popularVideos = new MutableLiveData<>();

    private LiveData<Resource<YoutubeResponse>> popularVideos = _popularVideos;

    @Inject
    public HomeViewModel(NetworkHelper networkHelper, FetchVideosRepository fetchVideosRepository) {
        this.networkHelper = networkHelper;
        this.fetchVideosRepository = fetchVideosRepository;

        fetchPopularVideos();
    }

    private void fetchPopularVideos() {
        _popularVideos.postValue(Resource.loading(null));
        fetchVideosRepository.getPopularVideos().enqueue(new Callback<YoutubeResponse>() {
            @Override
            public void onResponse(Call<YoutubeResponse> call, Response<YoutubeResponse> response) {
                _popularVideos.postValue(handleYoutubeResponse(response));
            }

            @Override
            public void onFailure(Call<YoutubeResponse> call, Throwable t) {
                _popularVideos.postValue(Resource.error(null, t.getMessage()));
            }
        });
    }

    private Resource<YoutubeResponse> handleYoutubeResponse(Response<YoutubeResponse> response) {
        if (response.isSuccessful()) {
            YoutubeResponse youtubeResponse = response.body();
            if (youtubeResponse != null) {
                return Resource.success(youtubeResponse);
            }
        }
        return Resource.error(null, "Something went wrong");
    }

    public LiveData<Resource<YoutubeResponse>> getPopularVideos() {
        return popularVideos;
    }
}
