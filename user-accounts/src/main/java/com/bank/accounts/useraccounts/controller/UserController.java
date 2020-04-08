package com.bank.accounts.useraccounts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    @Autowired
    private AccountDao service;

    @GetMapping("/accounts")
    public List<Account> retrievalAllAccounts(){
        return service.findAll();
    }
    @GetMapping("/accounts/{accountNumber}")
    public Account retrieveAccount(@PathVariable int accountNumber) {
        return service.findOne(accountNumber);
    }
    @PostMapping("/accounts")
    public void createAccount(@RequestBody Account account){
        Account savedAccount = service.save(account);

    }
}
