package com.banking.banking.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
@JsonIgnoreProperties("account")
public class StatementOfAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    @CreationTimestamp
    private LocalDateTime date;
    private String transactionType;
    private String narration;
    private Double amount=0.0;
    private Double accountBalance = 0.0;
    @OneToOne(fetch = FetchType.EAGER)
    private Account account;


    public StatementOfAccount(LocalDateTime date, String transactionType, String narration, Double amount, Double accountBalance) {
        this.date = date;
        this.transactionType = transactionType;
        this.narration = narration;
        this.amount = amount;
        this.accountBalance = accountBalance;
    }

    public StatementOfAccount(String transactionType, String narration, Double amount) {
        this.transactionType = transactionType;
        this.narration = narration;
        this.amount = amount;
    }

    public StatementOfAccount(LocalDateTime date, String transactionType, String narration, Double amount) {
        this.date = date;
        this.transactionType = transactionType;
        this.narration = narration;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {

        this.amount = amount;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public double getAccountBalance() {
        return account.getBalance() + amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
