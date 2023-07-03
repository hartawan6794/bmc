package com.example.bmc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.bmc.Fragment.DashboardFragment;
import com.example.bmc.Fragment.ProfileFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class DashboardActivity extends AppCompatActivity {

    private ChipNavigationBar chipNavigationBar;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        chipNavigationBar = findViewById(R.id.chipNavBar);
        chipNavigationBar.setItemSelected(R.id.dashboard,true);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new DashboardFragment()).commit();

        chipNavigationBar.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                if(i == R.id.dashboard)
                    fragment = new DashboardFragment();
                else if(i == R.id.profile)
                    fragment = new ProfileFragment();

                if(fragment!=null){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
                }
            }
        });
    }

}