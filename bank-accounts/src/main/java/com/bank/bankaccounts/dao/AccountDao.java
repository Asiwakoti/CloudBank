package com.bank.bankaccounts.dao;


import com.bank.bankaccounts.model.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class AccountDao {
    private static List<Account> accounts = new ArrayList<>();
    private static int accountsCount = 4;
    static {
        accounts.add(new Account(1, 5000, "Saving"));
        accounts.add(new Account(2, 2000, "Checking"));
        accounts.add(new Account(3, 3000, "Saving"));
        accounts.add(new Account(4, 4000, "Checking"));
    }
    public List<Account> findAll(){
        return accounts;
    }
    public Account save(Account account) {
        if (account.getAccountNumber() == null){
            account.setAccountNumber(++accountsCount);
        }

        accounts.add(account);
        return account;
    }
    public Account findOne(int accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }
}
