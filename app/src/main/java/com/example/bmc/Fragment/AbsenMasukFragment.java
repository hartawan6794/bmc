package com.example.bmc.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bmc.R;
import com.example.bmc.adapter.ViewAbsenAdapter;
import com.example.bmc.model.AbsenModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AbsenMasukFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AbsenMasukFragment extends Fragment {

    private RecyclerView rv_absen_masuk;
    private ViewAbsenAdapter absenAdapter;
    private List<AbsenModel> absenModels;
    private AbsenModel absenModel;


    public AbsenMasukFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_absen_masuk, container, false);
        rv_absen_masuk = view.findViewById(R.id.rv_absen_masuk);
        rv_absen_masuk.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv_absen_masuk.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
        rv_absen_masuk.setNestedScrollingEnabled(true);
        rv_absen_masuk.setHasFixedSize(false);
        setAbsen_Masuk();
        // Inflate the layout for this fragment
        return view;
    }

    private void setAbsen_Masuk(){
        absenModels = new ArrayList<>();
        for(int i = 0; i<100;i++){
            absenModel = new AbsenModel();
            absenModel.setJabatan("Jabatan "+ i);
            absenModel.setNama("Nama : "+i);
            absenModel.setJm_absen("07.30");
            absenModels.add(absenModel);
        }

        absenAdapter = new ViewAbsenAdapter(absenModels,getActivity());
        rv_absen_masuk.setAdapter(absenAdapter);
    }
}