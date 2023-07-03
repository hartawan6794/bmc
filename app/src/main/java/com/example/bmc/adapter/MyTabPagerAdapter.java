package com.example.bmc.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.bmc.Fragment.AbsenKeluarFragment;
import com.example.bmc.Fragment.AbsenMasukFragment;

public class MyTabPagerAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 2; // Jumlah tab/fragment

    public MyTabPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        // Return Fragment sesuai posisi
        switch (position) {
            case 0:
                return new AbsenMasukFragment();
            case 1:
                return new AbsenKeluarFragment();
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }

}
