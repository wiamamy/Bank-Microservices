package me.sqli.customer.services;

import me.sqli.clients.customer.CustomerRequest;
import me.sqli.customer.entities.Customer;

public interface CustomerService {
    Customer createCustomer(Customer customer);

    Customer registerCustomer(CustomerRequest customerRequest);

    Customer getCustomerByAccountNo(Long accountNo);
    void deleteCustomer(Long accountNo);
}
