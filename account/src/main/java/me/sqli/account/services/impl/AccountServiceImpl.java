package me.sqli.account.services.impl;

import java.sql.Date;
import java.time.Instant;

import org.springframework.stereotype.Service;

import me.sqli.account.entities.Account;
import me.sqli.account.entities.AccountType;
import me.sqli.account.entities.Balance;
import me.sqli.account.repositories.AccountRepository;
import me.sqli.account.services.AccountService;
import me.sqli.clients.customer.CustomerClient;
import me.sqli.clients.customer.CustomerRequest;

@Service
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;
    private final CustomerClient customerClient;
    public AccountServiceImpl(AccountRepository accountRepository, CustomerClient customerClient) {
        this.accountRepository = accountRepository;

        // Todo create balance
        // Todo create account Type
        // Todo create Customer
        this.customerClient = customerClient;
    }

    @Override
    public Account createAccount(Account account) {
        Account savedAccount= accountRepository.save(account);

        // Todo create account Type
        AccountType accountType=AccountType.builder()
            .accountNo(savedAccount.getAccountNo())
            .accountType("Active")
            .build();
        // Todo create balance
        Balance balance= Balance.builder()
            .accountNo(savedAccount.getAccountNo())
            .accountType(accountType.getAccountType())
            .balance(0)
            .build();

        // Todo create Customer
        customerClient.registerCustomer(new CustomerRequest(savedAccount.getAccountNo(),"","", Date.from(Instant.now()),"","","Active"));


        return savedAccount;
    }

    @Override
    public Account getAccountByAccountNo(Long accountNo) {
        return accountRepository.findById(accountNo).orElse(null);
    }

    @Override
    public void deleteAccount(Long accountNo) {
        accountRepository.deleteById(accountNo);
    }


}
