package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.exception.StorageException;
import org.otus.hw07.atm.storage.Storage;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

public class ATMWSImpl implements ATMWS {
    private Storage storage;
    private AlgorithmIssuingBanknotes algorithm;

    public ATMWSImpl(Storage storage, AlgorithmIssuingBanknotes algorithm) {
        this.storage = storage;
        this.algorithm = algorithm;
    }

    @Override
    public void inputBanknote(Banknote... banknotes) throws ATMException {
        for(Banknote banknote : banknotes){
            this.storage.addBanknote(banknote);
        }
    }

    @Override
    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void setAlgorithm(AlgorithmIssuingBanknotes algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public Collection<Banknote> outputBanknote(int value) throws ATMException {
        Map<Integer, Integer> payment = this.algorithm.getPayment(value, this.storage.getContentsInfo());
        return this.storage.getBanknotes(payment);
    }

    @Override
    public int getBalance() {
        return this.storage.getBalance();
    }

    @Override
    public SnapshotATM createSnapshotATM() {
        return new SnapshotATM(this, this.storage, this.algorithm);
    }
}
