package com.example.staj_proje.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.staj_proje.model.GecisKaydi;
import com.example.staj_proje.repository.GecisRepository;

@RestController
@RequestMapping("/api/pdks")
public class GecisController {

    private final GecisRepository gecisRepository;
    
    public GecisController(GecisRepository gecisRepository) {
        this.gecisRepository = gecisRepository;
    }

    @PostMapping("/gecis")
    public ResponseEntity<String> veriYakalaVeKaydet(@RequestBody GecisKaydi yeniKayit) {
        try {
            yeniKayit.setKayitTarihi(LocalDateTime.now());
            
            GecisKaydi kaydedilenVeri = gecisRepository.save(yeniKayit);
            
            System.out.println("[SUNUCU] Wokwi'den gelen veri veritabanına işlendi! ID: " + kaydedilenVeri.getId());
            return new ResponseEntity<>("Kayit Basarili. ID: " + kaydedilenVeri.getId(), HttpStatus.CREATED);
            
        } catch (Exception e) {
            return new ResponseEntity<>("Sistemsel Hata: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @org.springframework.web.bind.annotation.GetMapping("/tum-gecisler")
    public ResponseEntity<java.util.List<GecisKaydi>> tumGecisleriGetir() {
        try {
            java.util.List<GecisKaydi> listeler = gecisRepository.findAll();
            return ResponseEntity.ok(listeler);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
