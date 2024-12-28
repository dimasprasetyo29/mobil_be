package com.example.portofolio_design.portofolio_design.service;


import com.example.portofolio_design.portofolio_design.DTO.PasswordDTO;
import com.example.portofolio_design.portofolio_design.model.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {

    Admin registerAdmin(Admin admin);

    Admin getById(Long id);

    List<Admin> getAll();

    Admin edit(Long id, Admin admin);

    Admin putPasswordAdmin(PasswordDTO passwordDTO, Long id);

    Map<String, Boolean> delete(Long id);
}