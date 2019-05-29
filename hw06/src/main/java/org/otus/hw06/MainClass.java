package org.otus.hw06;

import org.otus.hw06.algorithm.AlgorithmIssuingBanknotesImpl;
import org.otus.hw06.banknote.*;
import org.otus.hw06.storage.StorageImpl;

import java.util.Collection;

public class MainClass {
    private static ATM atm;

    static {
        var storage = new StorageImpl();
        var algorithm = new AlgorithmIssuingBanknotesImpl();
        atm = new ATM(storage, algorithm);
    }

    public static void main(String[] args) {
        int balance1 = atm.getBalance();
        System.out.println("Balance: " + balance1);

        System.out.println("Ввод денег.");
        atm.inputBanknote(
                new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(),
                new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(),
                new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(),
                new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500()
        );

        int balance2 = atm.getBalance();
        System.out.println("Balance: " + balance2);

        out(760);
        out(1500);
        out(1000);
        out(35);
        out(3000);

        int residue = atm.getBalance();
        System.out.println("Balance: " + residue);
    }

    private static void out(int value) {
        try {
            System.out.println("Снятие: " + value);

            Collection<Banknote> out = atm.outputBanknote(value);
            System.out.println(out);

            int residue = atm.getBalance();
            System.out.println("Balance: " + residue);
        } catch (Exception e){
            System.err.println(e.toString());
        }
    }
}
