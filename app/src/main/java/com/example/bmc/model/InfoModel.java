package com.example.bmc.model;

import java.io.Serializable;

public class InfoModel implements Serializable {

    private String img_info;
    private String jdl_info;
    private String isi_content;
    private String id_info;


    public String getImg_info() {
        return img_info;
    }

    public String getIsi_content() {
        return isi_content;
    }

    public void setIsi_content(String isi_content) {
        this.isi_content = isi_content;
    }

    public void setImg_info(String img_info) {
        this.img_info = img_info;
    }

    public String getJdl_info() {
        return jdl_info;
    }

    public void setJdl_info(String jdl_info) {
        this.jdl_info = jdl_info;
    }

    public String getId_info() {
        return id_info;
    }

    public void setId_info(String id_info) {
        this.id_info = id_info;
    }
}
