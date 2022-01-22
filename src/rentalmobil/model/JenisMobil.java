/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rentalmobil.model;

/**
 *
 * @author Khanza
 */
public class JenisMobil {
    
    private Long kode;
    private String nama;

    public JenisMobil() {
    }

    public JenisMobil(String nama) {
        this.nama = nama;
    }

    public JenisMobil(Long kode, String nama) {
        this.kode = kode;
        this.nama = nama;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JenisMobil{kode=").append(kode);
        sb.append(", nama=").append(nama);
        sb.append('}');
        return sb.toString();
    }
    
}
