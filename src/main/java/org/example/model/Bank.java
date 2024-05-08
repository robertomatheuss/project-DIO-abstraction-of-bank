package org.example.model;

import java.util.HashSet;
import java.util.Set;

public class Bank {

    private String name;
    private Set<Branch> branchSet;

    public Bank(String bank) {
        this.name = bank;
        branchSet = new HashSet<>();
    }

    public static Bank createdBank(String name){
        return new Bank(name);
    }

    public Branch createdBranch(String locale){
        Branch newBranch = new Branch(locale);
        branchSet.add(newBranch);
        return newBranch;
    }

    public String getName() {
        return name;
    }

    public Set<Branch> getBranchSet() {
        return branchSet;
    }
}
