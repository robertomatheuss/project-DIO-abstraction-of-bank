package org.example.model;

import java.util.Objects;

public abstract class Account {
    private static Integer SEQUENTIAL = 1;

    protected Branch branch;
    protected Integer number;
    protected Double balance;
    protected Client client;

    public Account(Client client,Branch branch) {
        this.branch = branch;
        this.number = SEQUENTIAL++;
        this.client = client;
        this.balance = 0.0;
    }

    public void withdraw(Double value) {
        balance -= value;
    }

    public void deposit(Double value) {
        balance += value;
    }

    public void transfer(Double value, Account destinationAccount) {
        this.withdraw(value);
        destinationAccount.deposit(value);
    }

    public Branch getBranch() {
        return branch;
    }

    public int getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(branch, account.branch) && Objects.equals(number, account.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(branch, number);
    }

    @Override
    public String toString() {
        return String.format("Owner: %s \n", this.client.getName()) +
                String.format("Branch: %d\n",branch.getNumber()) +
                String.format("Number: %d\n", this.number) +
                String.format("Balance: %.2f\n", this.balance);
    }
}
