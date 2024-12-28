package com.example.portofolio_design.portofolio_design.repository;

import com.example.portofolio_design.portofolio_design.model.Mobil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MobilRepository extends JpaRepository<Mobil, Long> {



}