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
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bmc.R;
import com.example.bmc.model.InfoModel;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    private Context context;
    private ArrayList<InfoModel> infoModels;

    public InfoAdapter(Context context, ArrayList<InfoModel> infoModels){
        this.context = context;
        this.infoModels = infoModels;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private AppCompatImageView img_info;
        private AppCompatTextView tv_judul;
        private AppCompatButton btn_lihat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_info = itemView.findViewById(R.id.img_info);
            tv_judul = itemView.findViewById(R.id.judul_info);
            btn_lihat = itemView.findViewById(R.id.btn_lihat);
        }

        void bind(final InfoModel infoModel){
            tv_judul.setText(infoModel.getJdl_info());
            Glide.with(context).load(R.drawable.info_exam).into(img_info);
            btn_lihat.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "Lihat", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }


    @NonNull
    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.layout_info, parent, false);
        return new InfoAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoAdapter.ViewHolder holder, int position) {
        holder.bind(infoModels.get(position));
    }

    @Override
    public int getItemCount() {
        return infoModels.size();
    }
}
