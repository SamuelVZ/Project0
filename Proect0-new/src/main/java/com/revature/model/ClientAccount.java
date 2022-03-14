package com.revature.model;

import java.util.Objects;

public class ClientAccount {
    private int client_id;
    private int account_id;
    private int balance;

    public ClientAccount() {
    }

    public ClientAccount(int client_id, int account_id, int balance) {
        this.client_id = client_id;
        this.account_id = account_id;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ClientAccount{" +
                "client_id=" + client_id +
                ", account_id=" + account_id +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientAccount that = (ClientAccount) o;
        return client_id == that.client_id && account_id == that.account_id && balance == that.balance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(client_id, account_id, balance);
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
