package org.example.model;

import org.example.exception.BankException;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Branch {
    private static int SEQUENTIAL = 0;

    private String locale;
    private Integer number;
    private Set<Account> accountSet;

    public Branch(String locale){
        this.locale = locale;
        this.number = ++SEQUENTIAL;
        accountSet = new HashSet<>();
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void addAccount(Account account){
        if (thereIsAccountInBranch(account)){
            throw new BankException("There is account in this branch.");
        }
        accountSet.add(account);
    }
    private Boolean thereIsAccountInBranch(Account account){
        return accountSet.stream()
                .anyMatch(account1->Objects.equals(account1.branch,account.branch) && Objects.equals(account1.number, account.number));
    }

    public String getLocale() {
        return locale;
    }

    public Integer getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(number, branch.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "Branch in "+locale+ ", number: "+number+
                ", contains "+ accountSet.size()+ " accounts.";
    }
}
