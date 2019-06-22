package org.otus.hw06;

import org.otus.hw06.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw06.banknote.Banknote;
import org.otus.hw06.banknote.Nominal;
import org.otus.hw06.exception.ATMException;
import org.otus.hw06.exception.BalanceException;
import org.otus.hw06.storage.Storage;

import java.util.*;
import java.util.stream.Stream;

public class ATM {
    private Storage storage;
    private AlgorithmIssuingBanknotes algorithm;

    public ATM(Storage storage, AlgorithmIssuingBanknotes algorithm) {
        this.storage = storage;
        this.algorithm = algorithm;
    }

    public void inputBanknote(Banknote... banknote) {
        Arrays.stream(banknote).forEach(b -> this.storage.setBanknote(b));
    }

    public Collection<Banknote> outputBanknote(int value) throws ATMException {
        try {
            return getBanknotes(value);
        } catch (BalanceException e) {
            throw  new ATMException(e.toString());
        }
    }

    public int getBalance() {
        return this.storage.getBalance();
    }

    private List<Banknote> getBanknotes(int value) throws BalanceException {
        Map<Nominal, Integer> map = calculationOutput(value);
        return this.storage.getBanknote(map);
    }

    private Map<Nominal, Integer> calculationOutput(int value) throws BalanceException {
        this.algorithm.setGivenNumber(value);
        this.algorithm.setNominal(this.storage.getNominal());
        return this.algorithm.getPayment();
    }
}
