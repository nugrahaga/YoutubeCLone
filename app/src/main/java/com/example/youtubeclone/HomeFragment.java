package com.example.youtubeclone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        HomeVideoAdapter.HomeVideoData data1 = new HomeVideoAdapter.HomeVideoData("Video 1", "Video 1 Description");
        HomeVideoAdapter.HomeVideoData data2 = new HomeVideoAdapter.HomeVideoData("Video 2", "Video 2 Description");
        HomeVideoAdapter.HomeVideoData data3 = new HomeVideoAdapter.HomeVideoData("Video 3", "Video 3 Description");
        HomeVideoAdapter.HomeVideoData data4 = new HomeVideoAdapter.HomeVideoData("Video 4", "Video 4 Description");
        HomeVideoAdapter.HomeVideoData data5 = new HomeVideoAdapter.HomeVideoData("Video 5", "Video 5 Description");
        HomeVideoAdapter.HomeVideoData data6 = new HomeVideoAdapter.HomeVideoData("Video 6", "Video 6 Description");
        HomeVideoAdapter.HomeVideoData data7 = new HomeVideoAdapter.HomeVideoData("Video 7", "Video 7 Description");
        HomeVideoAdapter.HomeVideoData data8 = new HomeVideoAdapter.HomeVideoData("Video 8", "Video 8 Description");
        HomeVideoAdapter.HomeVideoData data9 = new HomeVideoAdapter.HomeVideoData("Video 9", "Video 9 Description");
        HomeVideoAdapter.HomeVideoData data10 = new HomeVideoAdapter.HomeVideoData("Video 10", "Video 10 Description");

        List<HomeVideoAdapter.HomeVideoData> dataList = Arrays.asList(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);

        HomeVideoAdapter adapter = new HomeVideoAdapter(dataList, getContext());

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}