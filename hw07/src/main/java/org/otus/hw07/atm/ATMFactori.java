package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotesImpl;
import org.otus.hw07.atm.banknote.*;
import org.otus.hw07.atm.storage.BanknotesСontainer;
import org.otus.hw07.atm.storage.ContainersStorage;
import org.otus.hw07.atm.storage.StorageImpl;

import java.util.HashSet;
import java.util.Set;

public class ATMFactori {
    //TODO Обернуть в билдер !!!
    public static ATMWS standartATM(){
        AlgorithmIssuingBanknotesImpl algorithmIssuingBanknotes = new AlgorithmIssuingBanknotesImpl();
        StorageImpl storage = new StorageImpl();
        ATMWS atm = new ATMWSImps(storage, algorithmIssuingBanknotes);
        atm.inputBanknote(
                new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(),
                new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(),
                new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(),
                new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500()
        );
        return atm;
    }

    public static ATMWS containerStorageATM(){
        AlgorithmIssuingBanknotesImpl algorithmIssuingBanknotes = new AlgorithmIssuingBanknotesImpl();
        Set<BanknotesСontainer> set = new HashSet<>();
        set.add(new BanknotesСontainer(Nominal.NOMINAL_10));
        set.add(new BanknotesСontainer(Nominal.NOMINAL_50));
        set.add(new BanknotesСontainer(Nominal.NOMINAL_100));
        set.add(new BanknotesСontainer(Nominal.NOMINAL_500));
        ContainersStorage storage = new ContainersStorage(set);
        ATMWS atm = new ATMWSImps(storage, algorithmIssuingBanknotes);
        atm.inputBanknote(
                new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(), new BanknoteNominal10(),
                new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(), new BanknoteNominal50(),
                new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(), new BanknoteNominal100(),
                new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500(), new BanknoteNominal500()
        );
        return atm;
    }
}
