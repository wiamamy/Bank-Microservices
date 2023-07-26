package me.sqli.transaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.transaction.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
