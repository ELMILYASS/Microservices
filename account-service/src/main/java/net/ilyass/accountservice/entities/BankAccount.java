package net.ilyass.accountservice.entities;


import jakarta.persistence.*;
import lombok.*;
import net.ilyass.accountservice.enums.AccountType;
import net.ilyass.accountservice.models.Customer;

import java.time.LocalDate;

@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

public class BankAccount {

    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long idCustomer;

}

