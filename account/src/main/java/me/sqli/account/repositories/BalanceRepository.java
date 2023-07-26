package me.sqli.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.account.entities.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Long> {
}
