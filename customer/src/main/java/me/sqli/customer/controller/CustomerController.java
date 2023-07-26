package me.sqli.customer.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.sqli.clients.customer.CustomerCheckResponse;
import me.sqli.clients.customer.CustomerRequest;
import me.sqli.customer.entities.Customer;
import me.sqli.customer.services.CustomerService;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

  /*  @GetMapping("/{accountNo}")
    public Customer getCustomerByAccountNo(@PathVariable Long accountNo) {
        return customerService.getCustomerByAccountNo(accountNo);
    }*/

    @PostMapping
    public void registerCustomer(@RequestBody CustomerRequest customerRequest){
        customerService.registerCustomer(customerRequest);
    }

    @GetMapping(path= "{customerId}")
    public CustomerCheckResponse getCustomerByAccountNo(@PathVariable Long accountNo){
        Customer customer = customerService.getCustomerByAccountNo(accountNo);

        //CustomerRequest customerRequest=new CustomerRequest();
        CustomerRequest customerRequest=CustomerRequest.builder().email(customer.getEmail())
            .mobile(customer.getMobile())
            .status(customer.getStatus())
            .fullName(customer.getFullName())
            .accountNo(customer.getAccountNo())
            .birthDate(customer.getBirthDate())
            .build();

        return new CustomerCheckResponse(customerRequest);
    }




}
