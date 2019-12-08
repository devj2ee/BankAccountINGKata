package com.bank.acount.kata.dao;

import com.bank.acount.kata.dao.model.Account;
import com.bank.acount.kata.dao.model.Client;
import com.bank.acount.kata.dao.model.Transaction;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * Created by IBRAHIM on 04/12/2019.
 */

@Repository
public class OperationDao {

    private Account account;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;
    private Client client;

    public OperationDao(Client client) {
        this.client = client;
        account = accountRepository.findByClient(client);
    }

    public Account deposit(Long amount) throws NotFoundException{
        Transaction transaction = new Transaction(amount,account);
        account.setAmount(account.getAmount()+amount);
        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }

    public Account withDrawal(Long amount) throws NotFoundException{
        checkAccount(amount);
        Transaction transaction = new Transaction(-amount,account);
        account.setAmount(account.getAmount()-amount);
        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }

    public Account withDrawalAll() throws NotFoundException {
        checkAccount(getCurrentAmount());
        Transaction transaction = new Transaction(-getCurrentAmount(),account);
        account.setAmount(0l);
        transactionRepository.save(transaction);
        return accountRepository.save(account);
    }

    public Set<Transaction> checkTransactions() {
        return transactionRepository.findByAccountByClient(client);
    }

    public void checkAccount(Long amount) throws NotFoundException {
        if(getCurrentAmount() -amount<0){
            throw new NotFoundException("You don't have this amount on your account");
        }
    }

    private Long getCurrentAmount() {
        return accountRepository.findById(account.getId()).get().getAmount();
    }
}
