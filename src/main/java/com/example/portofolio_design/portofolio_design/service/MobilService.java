package com.example.portofolio_design.portofolio_design.service;

import com.example.portofolio_design.portofolio_design.DTO.MobilDTO;
import com.example.portofolio_design.portofolio_design.model.Mobil;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface MobilService {

    List<Mobil> getAllMobil();

    Optional<Mobil> getMobilById(Long id);

    MobilDTO tambahMobilDTO(MobilDTO bakeryDTO);

    MobilDTO editMobilDTO(Long id, MobilDTO bakeryDTO) throws IOException;

    void deleteMobil(Long id) throws IOException;
}