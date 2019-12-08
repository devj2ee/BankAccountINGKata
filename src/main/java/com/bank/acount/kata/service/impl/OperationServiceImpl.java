package com.bank.acount.kata.service.impl;

import com.bank.acount.kata.dao.OperationDao;
import com.bank.acount.kata.dao.model.Account;
import com.bank.acount.kata.dao.model.Transaction;
import com.bank.acount.kata.service.OperationService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by IBRAHIM on 04/12/2019.
 */
@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationDao operationDao;

    public OperationServiceImpl(OperationDao operationDao) {
        this.operationDao = operationDao;
    }

    public Account deposit(Long amount) throws NotFoundException{
        return operationDao.deposit(amount);
    }

    public Account withDrawal(Long amount) throws NotFoundException {
        return operationDao.withDrawal(amount);
    }

    public Account withDrawalAll() throws NotFoundException {
        return operationDao.withDrawalAll();
    }

    public Set<Transaction> showTransactions() throws NotFoundException {
        return operationDao.checkTransactions();
    }

}
