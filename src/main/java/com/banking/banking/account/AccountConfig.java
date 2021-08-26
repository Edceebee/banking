package com.banking.banking.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepo accountRepo, StatementOfAccountRepo statementOfAccountRepo) {

        StatementOfAccount statement = new StatementOfAccount();
        statement.setTransactionType("Deposit");
        statement.setNarration("some narration");
        statement.setAmount(30000.00);
        statement.setDate(LocalDateTime.of(2020,1, 27, 12, 30 ));

        StatementOfAccount statement2 = new StatementOfAccount();
        statement2.setTransactionType("Deposit");
        statement2.setNarration("Deposit narration");
        statement2.setAmount(50000.00);
        statement2.setDate(LocalDateTime.now());

//        statementOfAccountRepo.save(statement);

        return args -> {
            Account account1 = new Account(

                    "Edozie Ifeanyi",
                    "0232616796",
                    70000.00
            );
            Account account2 = new Account(

                    "Edozie Maltida",
                    "0152919804",
                    48000.00
            );

            List<Account> accountList = accountRepo.saveAll(
                    List.of(account1, account2)
            );
            Account savedAccount1 = accountList.get(0);
            Account savedAccount2 = accountList.get(1);
            statement.setAccount(savedAccount2);
            statement2.setAccount(savedAccount2);

            statementOfAccountRepo.saveAll(
                    List.of(statement, statement2)
            );

        };
    }
}
