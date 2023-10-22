package com.example.youtubeclone.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.youtubeclone.R;
import com.example.youtubeclone.ui.account.AccountFragment;
import com.example.youtubeclone.ui.home.HomeFragment;
import com.example.youtubeclone.ui.shorts.ShortsFragment;
import com.example.youtubeclone.ui.subscriptions.SubscriptionsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private ShortsFragment shortsFragment = new ShortsFragment();
    private SubscriptionsFragment subscriptionsFragment = new SubscriptionsFragment();
    private AccountFragment accountFragment = new AccountFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (R.id.home == itemId) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, homeFragment)
                    .commit();
            return true;
        } else if (R.id.shorts == itemId) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, shortsFragment)
                    .commit();
            return true;
        } else if (R.id.create == itemId) {
            Toast.makeText(this, "NAV_CREATE", Toast.LENGTH_SHORT).show();
            return true;
        } else if (R.id.subscriptions == itemId) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, subscriptionsFragment)
                    .commit();
            return true;
        } else if (R.id.account == itemId) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_layout, accountFragment)
                    .commit();
            return true;
        }
        return false;
    }
}