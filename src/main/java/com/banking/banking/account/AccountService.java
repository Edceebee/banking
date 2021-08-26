package com.banking.banking.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepo accountRepo;

    @Autowired
    StatementOfAccountRepo statementOfAccountRepo;

//    public void createAccount(Account account){
//        Optional<Account> accountById = accountRepo.findById(account.getId());
//        if(accountById.isPresent()){
//            throw new IllegalArgumentException("id already taken");
//        }
//        accountRepo.save(account);
//    }

    public Account searchAccount(String accountNumber) {

        Optional<Account> accountList = accountRepo.findByAccountNumber(accountNumber);

        if (accountList.isPresent()) {
            return accountList.get();
        } else {
            throw new IllegalArgumentException("Account number does not exist");
        }
    }

    public StatementOfAccount getAccountStatement(String accountNumber) {
        Optional<StatementOfAccount> statement = statementOfAccountRepo.findFirstByAccount_AccountNumberOrderByDateDesc(accountNumber);
//        return statement.map(Account::getStatementOAccount).orElse(null);
        if (statement.isPresent()) {
            return statement.get();
        } else {
            throw new IllegalArgumentException("Account number does not exist");
        }

    }
}
