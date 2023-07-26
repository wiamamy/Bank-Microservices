package me.sqli.account.entities;

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
public class LoginHistory {
    @Id
    @Column(name = "token_id")
    private Long tokenId;

    @Column(name = "account_no", nullable = false)
    private Long accountNo;

    @Column(name = "login_time", nullable = false)
    private Date loginTime;

    @Column(name = "logout_time")
    private Date logoutTime;

}
