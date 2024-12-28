package com.example.portofolio_design.portofolio_design.impl;

import com.example.portofolio_design.portofolio_design.DTO.MobilDTO;
import com.example.portofolio_design.portofolio_design.exception.NotFoundException;
import com.example.portofolio_design.portofolio_design.model.Mobil;
import com.example.portofolio_design.portofolio_design.repository.MobilRepository;
import com.example.portofolio_design.portofolio_design.service.MobilService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MobilImpl implements MobilService {

    private final MobilRepository mobilRepository;

    public MobilImpl(MobilRepository mobilRepository) {
        this.mobilRepository = mobilRepository;
    }

    @Override
    public List<Mobil> getAllMobil() {
        return mobilRepository.findAll();
    }

    @Override
    public Optional<Mobil> getMobilById(Long id) {
        return mobilRepository.findById(id);
    }

    @Override
    public MobilDTO tambahMobilDTO(MobilDTO mobilDTO) {
        Mobil mobil = new Mobil();
        mobil.setNamaMobil(mobilDTO.getNamaMobil());
        mobil.setHargaMobil(mobilDTO.getHargaMobil());

        Mobil savedMobil = mobilRepository.save(mobil);

        MobilDTO result = new MobilDTO();
        result.setId(savedMobil.getId());
        result.setNamaMobil(savedMobil.getNamaMobil());
        result.setHargaMobil(savedMobil.getHargaMobil());

        return result;
    }

    @Override
    public MobilDTO editMobilDTO(Long id, MobilDTO mobilDTO) throws IOException {
        Mobil existingMobil = mobilRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Mobil tidak ditemukan"));

        existingMobil.setNamaMobil(mobilDTO.getNamaMobil());
        existingMobil.setHargaMobil(mobilDTO.getHargaMobil());

        Mobil updatedMobil = mobilRepository.save(existingMobil);

        MobilDTO result = new MobilDTO();
        result.setId(updatedMobil.getId());
        result.setNamaMobil(updatedMobil.getNamaMobil());
        result.setHargaMobil(updatedMobil.getHargaMobil());

        return result;
    }

    @Override
    public void deleteMobil(Long id) throws IOException {
        if (!mobilRepository.existsById(id)) {
            throw new NotFoundException("Mobil tidak ditemukan");
        }
        mobilRepository.deleteById(id);
    }
}