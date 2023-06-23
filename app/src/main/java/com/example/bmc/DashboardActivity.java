package com.example.bmc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.bmc.adapter.InfoAdapter;
import com.example.bmc.model.InfoModel;

import java.util.ArrayList;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class DashboardActivity extends AppCompatActivity {

    private RecyclerView rv_info;
    private InfoAdapter infoAdapter;
    private ArrayList<InfoModel> infoModels = new ArrayList<>();
    private InfoModel infoModel;

    //dotsindicator
    private ScrollingPagerIndicator indicator ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        indicator = findViewById(R.id.indicator);
        rv_info = findViewById(R.id.rv_info);
        rv_info.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rv_info.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));
        setRv_info();
        indicator.attachToRecyclerView(rv_info);

    }


    private void setRv_info(){
        for(int i = 0; i<5;i++){
            infoModel = new InfoModel();
            infoModel.setId_info(String.valueOf(i));
            infoModel.setJdl_info("Judul : "+i);
            infoModels.add(infoModel);
        }

        infoAdapter = new InfoAdapter(this,infoModels);
        rv_info.setAdapter(infoAdapter);
    }
}