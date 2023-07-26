package me.sqli.account.services;

import me.sqli.account.entities.Account;

public interface AccountService {
    Account createAccount(Account account);

    Account getAccountByAccountNo(Long accountNo);

    void deleteAccount(Long accountNo);
}
