package com.example.staj_proje.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.staj_proje.model.GecisKaydi;
public interface GecisRepository extends JpaRepository<GecisKaydi, Long> {}
