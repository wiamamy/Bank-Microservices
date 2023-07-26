package me.sqli.transaction.entities;

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
public class Request {
  @Id
  @Column(name = "request_id")
  private Long requestId;

  @Column(name = "account_no", nullable = false)
  private Long accountNo;

  @Column(name = "to_account", nullable = false)
  private Long toAccount;

  @Column(name = "amount", nullable = false)
  private int amount;

  @Column(name = "message", nullable = false, length = 1000)
  private String message;

  @Column(name = "hasViewed", nullable = false)
  private boolean hasViewed;

  @Column(name = "status", nullable = false)
  private String status;

  @Column(name = "request_date", nullable = false)
  private Date requestDate;
}
