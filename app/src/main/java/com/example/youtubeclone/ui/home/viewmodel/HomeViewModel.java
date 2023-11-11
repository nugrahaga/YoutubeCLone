package com.example.youtubeclone.ui.home.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.youtubeclone.utils.NetworkHelper;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HomeViewModel extends ViewModel {

    private final NetworkHelper networkHelper;

    @Inject
    public HomeViewModel(NetworkHelper networkHelper) {
        this.networkHelper = networkHelper;
    }
}
