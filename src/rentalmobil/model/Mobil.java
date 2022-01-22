/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentalmobil.model;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 *
 * @author Khanza
 */
public class Mobil {
    
    private Long kode;
    private String nama;
    private String nomorKtp;
    private String nomorHp;
    private String jinisMobil;
    private LocalDate tanggalSewa;
    private LocalDate tanggalPengambilan;
    private String platNomor;
    private BigDecimal harga;

    public Mobil() {
    }

    public Mobil(Long kode, String nama, String nomorKtp, String nomorHp, String jinisMobil, LocalDate tanggalSewa, LocalDate tanggalPengambilan, String platNomor, BigDecimal harga) {
        this.kode = kode;
        this.nama = nama;
        this.nomorKtp = nomorKtp;
        this.nomorHp = nomorHp;
        this.jinisMobil = jinisMobil;
        this.tanggalSewa = tanggalSewa;
        this.tanggalPengambilan = tanggalPengambilan;
        this.platNomor = platNomor;
        this.harga = harga;
    }

    public Mobil(String nama, String nomorKtp, String nomorHp, String jinisMobil, LocalDate tanggalSewa, LocalDate tanggalPengambilan, String platNomor, BigDecimal harga) {
        this.nama = nama;
        this.nomorKtp = nomorKtp;
        this.nomorHp = nomorHp;
        this.jinisMobil = jinisMobil;
        this.tanggalSewa = tanggalSewa;
        this.tanggalPengambilan = tanggalPengambilan;
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

    public String getNomorKtp() {
        return nomorKtp;
    }

    public void setNomorKtp(String nomorKtp) {
        this.nomorKtp = nomorKtp;
    }

    public String getNomorHp() {
        return nomorHp;
    }

    public void setNomorHp(String nomorHp) {
        this.nomorHp = nomorHp;
    }

    public String getJinisMobil() {
        return jinisMobil;
    }

    public void setJinisMobil(String jinisMobil) {
        this.jinisMobil = jinisMobil;
    }

    public LocalDate getTanggalSewa() {
        return tanggalSewa;
    }

    public void setTanggalSewa(LocalDate tanggalSewa) {
        this.tanggalSewa = tanggalSewa;
    }

    public LocalDate getTanggalPengambilan() {
        return tanggalPengambilan;
    }

    public void setTanggalPengambilan(LocalDate tanggalPengambilan) {
        this.tanggalPengambilan = tanggalPengambilan;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mobil{kode=").append(kode);
        sb.append(", nama=").append(nama);
        sb.append(", nomorKtp=").append(nomorKtp);
        sb.append(", nomorHp=").append(nomorHp);
        sb.append(", jinisMobil=").append(jinisMobil);
        sb.append(", tanggalSewa=").append(tanggalSewa);
        sb.append(", tanggalPengambilan=").append(tanggalPengambilan);
        sb.append(", platNomor=").append(platNomor);
        sb.append(", harga=").append(harga);
        sb.append('}');
        return sb.toString();
    }
    
}
