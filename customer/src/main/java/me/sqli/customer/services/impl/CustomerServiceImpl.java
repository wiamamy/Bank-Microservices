package me.sqli.customer.services.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import me.sqli.clients.balance.BalanceClient;
import me.sqli.clients.customer.CustomerRequest;
import me.sqli.customer.entities.Customer;
import me.sqli.customer.repositories.CustomerRepository;
import me.sqli.customer.services.CustomerService;
import  me.sqli.clients.balance.BalanceCheckResponse;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    private final BalanceClient balanceClient;

    public CustomerServiceImpl(CustomerRepository customerRepository, BalanceClient balanceClient) {
        this.customerRepository = customerRepository;
        this.balanceClient = balanceClient;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer registerCustomer(CustomerRequest customerRequest) {
        return customerRepository.save(
            Customer.builder()
                .accountNo(customerRequest.getAccountNo())
                .fullName(customerRequest.getFullName())
                .email(customerRequest.getEmail())
                .status("Active")
                .birthDate(customerRequest.getBirthDate())
                .gender(customerRequest.getGender())
                .build()
        );
    }

    @Override
    public Customer getCustomerByAccountNo(Long accountNo) {
        return customerRepository.findById(accountNo).orElse(null);
    }

    @Override
    public void deleteCustomer(Long accountNo) {
        Customer customer = customerRepository.getCustomerByAccountNo(accountNo);
        if (customer != null) {
            BalanceCheckResponse balanceCheckResponse =
                balanceClient.isBalanceZero(customer.getAccountNo());

            if(!balanceCheckResponse.isBalanceZero()){
                throw new IllegalStateException("solde non nul");
            }
        }
        // Todo set statut=supprime
        customerRepository.deleteById(accountNo);
    }


}
