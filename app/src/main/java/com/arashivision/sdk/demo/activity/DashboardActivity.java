    package com.arashivision.sdk.demo.activity;

    import android.content.Intent;
    import android.os.Bundle;
    import android.util.Log;
    import android.view.MenuItem;
    import android.view.View;
    import android.widget.Button;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.fragment.app.Fragment;
    import androidx.fragment.app.FragmentTransaction;
    import androidx.recyclerview.widget.GridLayoutManager;
    import androidx.recyclerview.widget.RecyclerView;

    import com.arashivision.sdk.demo.R;
    import com.arashivision.sdk.demo.fragments.CameraFragment;
    import com.arashivision.sdk.demo.fragments.GalleryFragment;
    import com.arashivision.sdk.demo.fragments.HomeFragment;
    import com.arashivision.sdkcamera.camera.InstaCameraManager;
    import com.google.android.material.bottomnavigation.BottomNavigationView;
    import com.google.android.material.tabs.TabLayout;

    public class DashboardActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

        private RecyclerView scansRecyclerView;
        private BottomNavigationView bottomNavigation;
        private Button mBtnConnectWifi;
        private TabLayout tabLayout;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_dashboard);

            initViews();
            setupTabs();
            setupRecyclerView();
            setupBottomNavigation();
            setupConnectButton();

           // mBtnConnectWifi = findViewById(R.id.btn_connect_wifi);
           // mBtnConnectWifi.setOnClickListener(v -> openCamera(InstaCameraManager.CONNECT_TYPE_WIFI));

            // Load HomeFragment initially
            if (savedInstanceState == null) {
                loadFragment(new HomeFragment());
            }
        }


        private void initViews() {
            tabLayout = findViewById(R.id.tabLayout);
           // scansRecyclerView = findViewById(R.id.scansRecyclerView);
            bottomNavigation = findViewById(R.id.bottomNavigation);
        }

        private void setupTabs() {
            // Implementation for setupTabs method
        }

        private void setupRecyclerView() {
            if (scansRecyclerView != null) {
                scansRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                // TODO: Set adapter
            } else {
                Log.e("DashboardActivity", "RecyclerView is null. Check your layout file.");
            }
        }

        private void setupBottomNavigation() {
            bottomNavigation.setOnNavigationItemSelectedListener(this);
        }

        private void openFullDemoActivity() {
            Intent intent = new Intent(this, FullDemoActivity.class);
            startActivity(intent);
        }

        private void setupConnectButton() {
            Button connectButton = findViewById(R.id.bottomConnect);
            connectButton.setOnClickListener(v -> {
                Toast.makeText(DashboardActivity.this, "Connecting to Insta 360...", Toast.LENGTH_SHORT).show();
                openFullDemoActivity();
            });
        }

        private void openCamera(int connectType) {
            InstaCameraManager.getInstance().openCamera(connectType);
            Toast.makeText(this, "Attempting to connect camera via WiFi", Toast.LENGTH_SHORT).show();
            loadFragment(new CameraFragment());
        }

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.nav_home:
                    loadFragment(new HomeFragment());
                    return true;
                case R.id.nav_gallery:
                    loadFragment(new GalleryFragment());
                    return true;
                case R.id.nav_camera:
                    loadFragment(new CameraFragment());
                    return true;
                default:
                    return false;
            }
        }

        private void loadFragment(Fragment fragment) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.page_container, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
    }