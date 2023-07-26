package me.sqli.transaction.dto;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TransactionDto {
    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "trans_type", nullable = false)
    private String transType;

    @Column(name = "purpose", nullable = false, length = 100)
    private String purpose;

    @Column(name = "to_account", nullable = false)
    private Long toAccount;

    @Column(name = "account_no", nullable = false)
    private Long accountNo;

    @Column(name = "account_bal", nullable = false)
    private int accountBal;
}
