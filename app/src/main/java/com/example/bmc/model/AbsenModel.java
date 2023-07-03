package com.example.bmc.model;

import java.io.Serializable;

public class AbsenModel implements Serializable {

    String nama,jabatan,jm_absen,img,id_absen;

    public String getId_absen() {
        return id_absen;
    }

    public void setId_absen(String id_absen) {
        this.id_absen = id_absen;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getJm_absen() {
        return jm_absen;
    }

    public void setJm_absen(String jm_absen) {
        this.jm_absen = jm_absen;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
