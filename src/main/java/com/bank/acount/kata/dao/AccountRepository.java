package com.bank.acount.kata.dao;

import com.bank.acount.kata.dao.model.Account;
import com.bank.acount.kata.dao.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 * Created by IBRAHIM on 04/12/2019.
 */

@Component
public interface AccountRepository extends CrudRepository<Account, Long> {

    Account findByClient(Client client);
}
