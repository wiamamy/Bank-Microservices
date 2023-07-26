package me.sqli.clients.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("customer")
public interface CustomerClient {

    // Todo pas valide
    @GetMapping("api/v1/customers/{accountNo}")
    CustomerCheckResponse getCustomerByAccountNo(@PathVariable Long accountNo);

    @PostMapping("api/v1/customers")
    void registerCustomer(@RequestBody CustomerRequest customerRequest);
}
