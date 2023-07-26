package me.sqli.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.customer.entities.Address;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
