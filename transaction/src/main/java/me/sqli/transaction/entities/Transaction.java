package me.sqli.transaction.entities;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Transaction {
    @Id
    @Column(name = "trans_id")
    private Long transId;

    @Column(name = "trans_date", nullable = false)
    private LocalDateTime transDate;

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
