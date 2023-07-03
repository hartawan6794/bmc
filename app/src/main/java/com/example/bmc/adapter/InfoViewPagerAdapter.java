package com.example.bmc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.bmc.R;
import com.example.bmc.model.InfoModel;

import java.util.List;

public class InfoViewPagerAdapter extends PagerAdapter {

    //inisialisasi variable yang digunakan
    private List<InfoModel> infoModels;
    private LayoutInflater layoutInflater;
    private Context context;

    //membuat procedure untuk mendapatkan data dari class activity
    public InfoViewPagerAdapter(List<InfoModel> infoModels, Context context) {
        this.infoModels = infoModels;
        this.context = context;
    }

    //menampilkan jumlah data dari banyaknya data yang ada di infomodels
    @Override
    public int getCount() {
        return infoModels.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_info,container,false);
        AppCompatImageView img_info;
        AppCompatTextView tv_judul;
        AppCompatTextView isi_content;
        AppCompatButton btn_lihat;
        img_info = view.findViewById(R.id.img_info);
        tv_judul = view.findViewById(R.id.judul_info);
        isi_content = view.findViewById(R.id.isi_content);
        btn_lihat = view.findViewById(R.id.btn_lihat);

        Glide.with(context).load(R.drawable.info_exam).into(img_info);
        tv_judul.setText(infoModels.get(position).getJdl_info());
        isi_content.setText(infoModels.get(position).getIsi_content());
        btn_lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

        container.addView(view, 0);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
