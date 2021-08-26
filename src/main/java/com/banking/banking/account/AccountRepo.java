package com.banking.banking.account;

import com.banking.banking.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository <Account, Long>{
        Optional <Account> findByAccountNumber (String accountNumber);
}
