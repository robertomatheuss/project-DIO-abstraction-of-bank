package org.example.application;


import org.example.model.*;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Bank itau = Bank.createdBank("Itau");
        Branch branch01 = itau.createdBranch("SP");
        Branch branch02 = itau.createdBranch("RJ");

        Account current = new CurrentAccount(new Client("Luiz"),branch01);
        Account saving = new SavingAccount(new Client("Carlo"),branch01);

        Account current2 = new CurrentAccount(new Client("Luiz"),branch02);
        Account saving2 = new SavingAccount(new Client("Carlo"),branch02);
        
        itau.getBranchSet().forEach(x-> System.out.println(x.getAccountSet()));

    }
}