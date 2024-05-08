package org.example.model;

public class SavingAccount extends Account{

    public SavingAccount(Client client, Branch branch) {
        super(client, branch);
    }

    @Override
    public String toString() {
        return "Saving Account : "+
                super.toString();
    }
}
