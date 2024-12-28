package com.example.portofolio_design.portofolio_design.model;

import javax.persistence.*;

@Entity
@Table(name = "mobil")
public class Mobil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "namaMobil")
    private String namaMobil;

    @Column(name = "harga_namaMobil")
    private String hargaMobil;

    public Mobil(Long id, String namaMobil, String hargaMobil) {
        this.id = id;
        this.namaMobil = namaMobil;
        this.hargaMobil = hargaMobil;
    }

    public Mobil() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaMobil() {
        return namaMobil;
    }

    public void setNamaMobil(String namaMobil) {
        this.namaMobil = namaMobil;
    }

    public String getHargaMobil() {
        return hargaMobil;
    }

    public void setHargaMobil(String hargaMobil) {
        this.hargaMobil = hargaMobil;
    }
}