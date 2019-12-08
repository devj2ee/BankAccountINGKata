package com.bank.acount.kata.dao;

import com.bank.acount.kata.dao.model.Client;
import com.bank.acount.kata.dao.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Created by IBRAHIM on 04/12/2019.
 */

@Component
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Set<Transaction> findAll();
    Set<Transaction> findByAccountByClient(Client client);


}
