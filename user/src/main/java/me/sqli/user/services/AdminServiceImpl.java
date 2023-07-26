package me.sqli.user.services;

import me.sqli.user.repositories.AdminRepository;

public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
}
