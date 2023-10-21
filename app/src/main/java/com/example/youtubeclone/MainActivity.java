package com.example.youtubeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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