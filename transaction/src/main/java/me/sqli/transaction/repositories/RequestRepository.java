package me.sqli.transaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.transaction.entities.Request;

public interface RequestRepository extends JpaRepository<Request,Integer> {
}
