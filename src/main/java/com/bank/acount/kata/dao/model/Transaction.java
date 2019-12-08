package com.bank.acount.kata.dao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

/**
 * Created by IBRAHIM on 04/12/2019.
 */
@Entity
public class Transaction implements Serializable {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Long id;

    private Long amount;

    private Account account;

    private Instant date = Instant.now();

    public Transaction(Long amount, Account account) {
        this.amount = amount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
