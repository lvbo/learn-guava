package com.lvbo.guavatest.cache.model;

/**
 * Created by lvbo on 16/2/12.
 */
public class TradeAccount {
    private String id;
    private String owner;
    private double balance;

    public TradeAccount(String id, String owner, double balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }
}
