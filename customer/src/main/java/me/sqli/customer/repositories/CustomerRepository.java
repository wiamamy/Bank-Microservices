package me.sqli.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import me.sqli.customer.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer getCustomerByAccountNo(Long accountNo);
}
