package com.bank.acount.kata.controller;

import com.bank.acount.kata.dao.model.Account;
import com.bank.acount.kata.dao.model.Transaction;
import com.bank.acount.kata.service.OperationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by IBRAHIM on 07/12/2019.
 */
@RestController
@RequestMapping("api/bankAccount")
@EnableOAuth2Sso
public class BankAccountController {

    @Autowired
    private OperationService operationService;


    /**
     * deposit an amount
     *
     * @return the list
     */
    @PutMapping("/deposit")
    public ResponseEntity<Account> deposit(@RequestParam Long amount) throws NotFoundException {
        Account account= operationService.deposit(amount);
        return ResponseEntity.ok().body(account);
    }

    /**
     * withdrawall an amount
     *
     * @return the list
     */
    @PutMapping("/withDrawal")
    public ResponseEntity<Account> withDrawal(Long amount) throws NotFoundException {
        Account account= operationService.withDrawal(amount);
        return ResponseEntity.ok().body(account);
    }


    /**
     * withdrawall an amount
     *
     * @return the list
     */
    @PutMapping("/withDrawalAll")
    public ResponseEntity<Account> withDrawalAll() throws NotFoundException {
        Account account= operationService.withDrawalAll();
        return ResponseEntity.ok().body(account);
    }

    /**
     * show all Transactions
     *
     * @return the list
     */
    @GetMapping("/Transacations")
    public ResponseEntity<Set> showTransactions() throws NotFoundException {
        Set<Transaction> transactions= operationService.showTransactions();
        return ResponseEntity.ok().body(transactions);
    }

}
