package com.example.staj_proje.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personel_gecisleri")
public class GecisKaydi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cihazId;
    private String personelId;
    private String durum;
    private LocalDateTime kayitTarihi;

    public GecisKaydi() {}

    public Long getId() { return id; }
    public String getCihazId() { return cihazId; }
    public void setCihazId(String cihazId) { this.cihazId = cihazId; }
    public String getPersonelId() { return personelId; }
    public void setPersonelId(String personelId) { this.personelId = personelId; }
    public String getDurum() { return durum; }
    public void setDurum(String durum) { this.durum = durum; }
    public LocalDateTime getKayitTarihi() { return kayitTarihi; }
    public void setKayitTarihi(LocalDateTime kayitTarihi) { this.kayitTarihi = kayitTarihi; }
}
