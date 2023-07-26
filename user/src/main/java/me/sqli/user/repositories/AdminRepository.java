package me.sqli.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.user.entities.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {
}
