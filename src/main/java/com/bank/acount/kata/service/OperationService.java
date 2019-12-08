package com.bank.acount.kata.service;

import com.bank.acount.kata.dao.model.Account;
import com.bank.acount.kata.dao.model.Transaction;
import javassist.NotFoundException;

import java.util.Set;

/**
 * Created by IBRAHIM on 04/12/2019.
 */
public interface OperationService {

    Account deposit(Long amount) throws NotFoundException;

    Account withDrawal(Long amount) throws NotFoundException;

    Account withDrawalAll() throws NotFoundException;

    Set<Transaction> showTransactions() throws NotFoundException;
}
