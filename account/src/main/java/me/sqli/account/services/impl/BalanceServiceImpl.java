package me.sqli.account.services.impl;

import org.springframework.stereotype.Service;

import me.sqli.account.entities.Balance;
import me.sqli.account.repositories.BalanceRepository;
import me.sqli.account.services.BalanceService;

@Service
public class BalanceServiceImpl implements BalanceService {
    private final BalanceRepository balanceRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Balance createBalaceforAccount(Balance balance){
        return balanceRepository.save(balance);
    }

    public Balance getBalanceByAccountNo(Long accountNo) {
        return balanceRepository.findById(accountNo).orElse(null);
    }

    public void updateBalance(Balance balance) {
        balanceRepository.save(balance);
    }

    public void deleteBalance(Long accountNo) {
        balanceRepository.deleteById(accountNo);
    }

    @Override
    public boolean checkBalanceIsZero(Long accountNo) {
        Balance balance = balanceRepository.findById(accountNo).orElse(null);
        return balance != null && balance.getBalance() == 0;
    }
}
