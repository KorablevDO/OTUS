package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.banknote.Nominal;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.exception.BalanceException;
import org.otus.hw07.atm.storage.Storage;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ATMIpl implements ATM {
    private Storage storage;
    private AlgorithmIssuingBanknotes algorithm;

    public ATMIpl(Storage storage, AlgorithmIssuingBanknotes algorithm) {
        this.storage = storage;
        this.algorithm = algorithm;
    }

    public void inputBanknote(Banknote... banknote) {
        Arrays.stream(banknote).forEach(b -> this.storage.addBanknote(b));
    }

    public Collection<Banknote> outputBanknote(int value) throws ATMException {
        return getBanknotes(value);
    }

    public int getBalance() {
        return this.storage.getBalance();
    }

    private List<Banknote> getBanknotes(int value) throws BalanceException {
        Map<Nominal, Integer> map = calculationOutput(value);
        return this.storage.getBanknotes(map);
    }

    private Map<Nominal, Integer> calculationOutput(int value) throws BalanceException {
        return this.algorithm.getPayment(value, this.storage.getContentsInfo());
    }
}
