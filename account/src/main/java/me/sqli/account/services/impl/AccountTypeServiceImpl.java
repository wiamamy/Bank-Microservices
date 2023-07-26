package me.sqli.account.services.impl;

import me.sqli.account.entities.AccountType;
import me.sqli.account.repositories.AccountTypeRepository;

public class AccountTypeServiceImpl {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeServiceImpl(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    public AccountType createAccountType(AccountType accountType){
        return accountTypeRepository.save(accountType);
    }
}
