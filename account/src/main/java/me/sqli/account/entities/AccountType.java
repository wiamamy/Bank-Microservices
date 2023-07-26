package me.sqli.account.entities;

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
public class AccountType {
    @Id
    @Column(name = "account_no")
    private Long accountNo;

    @Column(name = "account_type", nullable = false)
    private String accountType;
}
