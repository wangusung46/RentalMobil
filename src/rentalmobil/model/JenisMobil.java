/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentalmobil.model;

import java.math.BigDecimal;

/**
 *
 * @author Khanza
 */
public class JenisMobil {
    
    private Long kode;
    private String nama;
    private String platNomor;
    private BigDecimal harga;

    public JenisMobil() {
    }

    public JenisMobil(String nama, String platNomor, BigDecimal harga) {
        this.nama = nama;
        this.platNomor = platNomor;
        this.harga = harga;
    }

    public JenisMobil(Long kode, String nama, String platNomor, BigDecimal harga) {
        this.kode = kode;
        this.nama = nama;
        this.platNomor = platNomor;
        this.harga = harga;
    }

    public Long getKode() {
        return kode;
    }

    public void setKode(Long kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public void setPlatNomor(String platNomor) {
        this.platNomor = platNomor;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }
    
}
