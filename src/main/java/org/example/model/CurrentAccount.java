package org.example.model;

public class CurrentAccount extends Account{
    public CurrentAccount(Client client, Branch branch) {
        super(client, branch);
    }

    @Override
    public String toString() {
        return "Current Account : "+
                super.toString();
    }
}
