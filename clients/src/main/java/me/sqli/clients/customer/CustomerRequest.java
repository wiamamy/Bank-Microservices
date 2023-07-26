package me.sqli.clients.customer;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest {
    private Long accountNo;

    private String fullName;

    private String gender;

    private Date birthDate;

    private String mobile;

    private String email;

    private String status;
}
