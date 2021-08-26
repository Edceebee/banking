package com.banking.banking.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String accountName;
    private String accountNumber;
    private Double balance;

//    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
//    private StatementOfAccount statementOAccount;

    public Account(String accountName, String accountNumber, Double balance) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


}
