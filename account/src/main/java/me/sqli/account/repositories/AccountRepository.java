package me.sqli.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.account.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
