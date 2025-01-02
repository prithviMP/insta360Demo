package com.arashivision.sdk.demo.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.arashivision.sdk.demo.R;
import com.arashivision.sdk.demo.fragments.CameraFragment;
import com.arashivision.sdk.demo.fragments.GalleryFragment;
import com.arashivision.sdk.demo.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public  class BaseActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        // Load the default fragment (Home) initially
        if (savedInstanceState == null) {
            loadFragment(new HomeFragment());
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        Fragment selectedFragment = null;

        switch (item.getItemId()) {
            case R.id.nav_home:
                selectedFragment = new HomeFragment();
                break;

            case R.id.nav_gallery:
                selectedFragment = new GalleryFragment();
                break;

            case R.id.nav_camera:
                selectedFragment = new CameraFragment();
                break;
        }

        if (selectedFragment != null) {
            loadFragment(selectedFragment);
            return true;
        }
        return false;
    }

    private void loadFragment(Fragment fragment) {
        // Replace the existing fragment and add the transaction to the back stack
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.page_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        // Handle the back press to navigate correctly
        if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
            getSupportFragmentManager().popBackStack();
        } else {
            // If only one fragment remains, finish the activity
            finish();
        }
    }
}