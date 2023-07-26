package me.sqli.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.account.entities.LoginHistory;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Long> {
}
