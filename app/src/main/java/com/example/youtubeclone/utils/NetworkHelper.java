package com.example.youtubeclone.utils;

import android.content.Context;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.hilt.android.qualifiers.ApplicationContext;

@Singleton
public class NetworkHelper {

    @Inject
    public NetworkHelper(@ApplicationContext Context context) {
    }
}
