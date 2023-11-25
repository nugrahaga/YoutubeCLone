package com.example.youtubeclone.ui.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.youtubeclone.R;
import com.example.youtubeclone.data.repository.HomeVideoData;
import com.example.youtubeclone.ui.MainActivity;
import com.example.youtubeclone.ui.home.adapter.HomeVideoAdapter;
import com.example.youtubeclone.ui.home.viewmodel.HomeViewModel;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private Toolbar toolbar;

    private HomeViewModel viewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setHasOptionsMenu(true);
        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        toolbar = view.findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

//        HomeVideoData data1 = new HomeVideoData("Video 1", "Video 1 Description");
//        HomeVideoData data2 = new HomeVideoData("Video 2", "Video 2 Description");
//        HomeVideoData data3 = new HomeVideoData("Video 3", "Video 3 Description");
//        HomeVideoData data4 = new HomeVideoData("Video 4", "Video 4 Description");
//        HomeVideoData data5 = new HomeVideoData("Video 5", "Video 5 Description");
//        HomeVideoData data6 = new HomeVideoData("Video 6", "Video 6 Description");
//        HomeVideoData data7 = new HomeVideoData("Video 7", "Video 7 Description");
//        HomeVideoData data8 = new HomeVideoData("Video 8", "Video 8 Description");
//        HomeVideoData data9 = new HomeVideoData("Video 9", "Video 9 Description");
//        HomeVideoData data10 = new HomeVideoData("Video 10", "Video 10 Description");
//
//        List<HomeVideoData> dataList = Arrays.asList(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
//
        HomeVideoAdapter adapter = new HomeVideoAdapter(getContext());

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        viewModel.getPopularVideos().observe(getViewLifecycleOwner(), youtubeVideos -> {
            if (youtubeVideos != null) {
                if (youtubeVideos.getData() != null) {
                    adapter.setList(youtubeVideos.getData().getItems());
                } else {
                    Logger.getLogger("HomeFragment").warning("youtubeVideos.getData() is null");
                }
            }
//            adapter.setList(youtubeVideos.getData().getItems());
        });
    }
}