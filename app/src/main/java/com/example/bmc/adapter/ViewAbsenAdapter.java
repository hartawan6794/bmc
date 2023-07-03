package com.example.bmc.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.bmc.R;
import com.example.bmc.model.AbsenModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ViewAbsenAdapter extends RecyclerView.Adapter<ViewAbsenAdapter.ViewHolder> {

    private List<AbsenModel> absenModels;
    private Context contex;

    public ViewAbsenAdapter(List<AbsenModel> absenModels, Context contex) {
        this.absenModels = absenModels;
        this.contex = contex;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView img_absen;
        private AppCompatTextView nm_pgw_absen, jab_pgw_absen, jm_absen;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_absen = itemView.findViewById(R.id.img_absen);
            nm_pgw_absen = itemView.findViewById(R.id.nm_pgw_absen);
            jab_pgw_absen = itemView.findViewById(R.id.jab_pgw_absen);
            jm_absen = itemView.findViewById(R.id.jam_absen);
        }

        void bind(final AbsenModel absenModel){
            Glide.with(contex).load(R.drawable.profile_default).into(img_absen);
            nm_pgw_absen.setText(absenModel.getNama());
            jab_pgw_absen.setText(absenModel.getJabatan());
            jm_absen.setText(absenModel.getJm_absen());
        }

    }


    @NonNull
    @Override
    public ViewAbsenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_info_absensi,parent,false);
        return new ViewAbsenAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAbsenAdapter.ViewHolder holder, int position) {
        holder.bind(absenModels.get(position));
    }

    @Override
    public int getItemCount() {
        return absenModels.size();
    }
}
