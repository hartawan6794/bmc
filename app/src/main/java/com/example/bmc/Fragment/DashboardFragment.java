package com.example.bmc.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bmc.R;
import com.example.bmc.adapter.InfoViewPagerAdapter;
import com.example.bmc.adapter.MyTabPagerAdapter;
import com.example.bmc.model.InfoModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {


    //    private RecyclerView rv_info;
//    private InfoAdapter infoAdapter;
    private List<InfoModel> infoModels;
    private InfoModel infoModel;

    //dotsindicator
    private ScrollingPagerIndicator indicator ;

    //viewpager cardview swipe layout
    ViewPager viewPager;
    InfoViewPagerAdapter infoAdapter;

    //tablayout untuk absensi kehadiran harian
    private ViewPager2 vpAbsense;
    private TabLayout tabLayout;
    String[] tabTitle = {"Masuk","Pulang"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        indicator = view.findViewById(R.id.indicator);
        vpAbsense = view.findViewById(R.id.vp_absen);
        tabLayout = view.findViewById(R.id.tab_absen);
        setRv_info(view);
        indicator.attachToPager(viewPager);

        // Inisialisasi Adapter
        MyTabPagerAdapter pagerAdapter = new MyTabPagerAdapter(getActivity().getSupportFragmentManager(), getLifecycle());

        // Set Adapter ke ViewPager2
        vpAbsense.setAdapter(pagerAdapter);

        // Tambahkan TabLayoutMediator untuk menghubungkan TabLayout dan ViewPager2
        new TabLayoutMediator(tabLayout, vpAbsense,
                (tab, position) -> tab.setText(tabTitle[position])
        ).attach();

        // Inflate the layout for this fragment
        return view;
    }


    private void setRv_info(View view){
        infoModels = new ArrayList<>();
        for(int i = 0; i<5;i++){
            infoModel = new InfoModel();
            infoModel.setId_info(String.valueOf(i));
            infoModel.setJdl_info("Judul : "+i);
            infoModel.setIsi_content(getResources().getString(R.string.info_terkini));
            infoModels.add(infoModel);
        }

        infoAdapter = new InfoViewPagerAdapter(infoModels,getActivity());
        viewPager = view.findViewById(R.id.rv_info);
        viewPager.setAdapter(infoAdapter);
        viewPager.setPadding(20,0,20,0);

//        Integer[] colors_temp = {getResources().getColor(R.color.primary)};
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//                if(position < (infoAdapter.getCount() - 1) && position < (colors.length - 1)){
//
//                    viewPager.setBackgroundColor((Integer) argbEvaluator.evaluate(positionOffset, colors[position], colors[position] -1));
//
//                }else{
//                    viewPager.setBackgroundColor(colors[colors.length - 1]);
//                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        rv_info.setAdapter(infoAdapter);

    }
}