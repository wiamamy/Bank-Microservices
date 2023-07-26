package me.sqli.clients.balance;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("balance")
public interface BalanceClient {

    @GetMapping(path="api/v1/balance/balance-check/{accountId}")
    BalanceCheckResponse isBalanceZero(@PathVariable("accountId") Long customerId);

    @GetMapping(path="api/v1/balance/{accountId}")
    Integer checkSufficientBalance(@PathVariable("accountId") Long customerId);
}
