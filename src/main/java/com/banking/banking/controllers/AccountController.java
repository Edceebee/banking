package com.banking.banking.controllers;

import com.banking.banking.account.Account;
import com.banking.banking.account.AccountService;
import com.banking.banking.account.StatementOfAccount;
import com.banking.banking.controllers.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/account_info/{accountNumber}")
    public ResponseEntity<?> searchAccount(@PathVariable("accountNumber") String accountNumber){
            try{
                Account foundAccount = accountService.searchAccount(accountNumber);
                return new ResponseEntity<>(foundAccount, HttpStatus.OK);
            } catch (IllegalArgumentException exception){
                return new ResponseEntity<>(new ApiResponse(exception.getMessage(), false), HttpStatus.BAD_REQUEST);
            }

    }

    @GetMapping("/account_statement/{accountNumber}")
    public ResponseEntity<?> statement(@PathVariable ("accountNumber") String accountNumber){
        try {
            StatementOfAccount statementOfAccount = accountService.getAccountStatement(accountNumber);
            return new ResponseEntity<>(statementOfAccount, HttpStatus.OK);
        } catch (IllegalArgumentException exception) {
            return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

}
