package me.sqli.account.controller;

import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.sqli.account.entities.Balance;
import me.sqli.account.repositories.BalanceRepository;
import  me.sqli.clients.balance.BalanceCheckResponse;

import lombok.extern.slf4j.Slf4j;
import me.sqli.account.services.BalanceService;

@RestController
@RequestMapping("api/v1/balance")
@Slf4j
public class BalanceController {

    private final BalanceService balanceService;
    private final BalanceRepository balanceRepository;

    public BalanceController(BalanceService balanceService, BalanceRepository balanceRepository) {
        this.balanceService = balanceService;
        this.balanceRepository = balanceRepository;
    }

    @GetMapping(path= "{balance-check/customerId}")
    public BalanceCheckResponse isBalanceZero(@PathVariable Long accountId){
        boolean isBalanceZero = balanceService.checkBalanceIsZero(accountId);
        //log.info("fraud check request for customer {}", customerId);
        return new BalanceCheckResponse(isBalanceZero);
    }

    @GetMapping(path= "{balance-check/customerId}")
    public Integer checkSufficientBalance(@PathVariable("accountId") Long customerId){
        Balance balance=balanceRepository.findById(customerId).orElse(null);
        return balance.getBalance();
    };
}
