package com.example.portofolio_design.portofolio_design.controller;

import com.example.portofolio_design.portofolio_design.DTO.MobilDTO;
import com.example.portofolio_design.portofolio_design.model.Mobil;
import com.example.portofolio_design.portofolio_design.service.MobilService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MobilController {

    private final MobilService mobilService;

    public MobilController(MobilService mobilService) {
        this.mobilService = mobilService;
    }

    @GetMapping("/mobil/all")
    public ResponseEntity<List<Mobil>> getAllMobil() {
        List<Mobil> mobilList = mobilService.getAllMobil();
        return ResponseEntity.ok(mobilList);
    }

    @GetMapping("/mobil/getById/{id}")
    public ResponseEntity<MobilDTO> getMobilById(@PathVariable Long id) {
        Optional<Mobil> mobil = mobilService.getMobilById(id);
        return mobil.map(mobilEntity -> {
            MobilDTO mobilDTO = new MobilDTO();
            mobilDTO.setId(mobilEntity.getId());
            mobilDTO.setNamaMobil(mobilEntity.getNamaMobil());
            mobilDTO.setHargaMobil(mobilEntity.getHargaMobil());
            return ResponseEntity.ok(mobilDTO);
        }).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/mobil/tambah")
    public ResponseEntity<MobilDTO> tambahMobil(@RequestBody MobilDTO mobilDTO) {
        MobilDTO savedMobil = mobilService.tambahMobilDTO(mobilDTO);
        return ResponseEntity.ok(savedMobil);
    }

    @PutMapping(value = "/mobil/editById/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MobilDTO> editMobil(
            @PathVariable Long id,
            @RequestBody MobilDTO mobilDTO) throws IOException {

        MobilDTO updatedMobil = mobilService.editMobilDTO(id, mobilDTO);
        return ResponseEntity.ok(updatedMobil);
    }

    @DeleteMapping("/mobil/delete/{id}")
    public ResponseEntity<Void> deleteMobil(@PathVariable Long id) throws IOException {
        mobilService.deleteMobil(id);
        return ResponseEntity.noContent().build();
    }
}