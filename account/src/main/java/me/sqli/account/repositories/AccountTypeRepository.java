package me.sqli.account.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.account.entities.AccountType;

public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {
}
