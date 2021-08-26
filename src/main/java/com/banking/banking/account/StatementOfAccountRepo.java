package com.banking.banking.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatementOfAccountRepo extends JpaRepository<StatementOfAccount, Long> {
   Optional<StatementOfAccount> findFirstByAccount_AccountNumberOrderByDateDesc(String accountNumber);

}

