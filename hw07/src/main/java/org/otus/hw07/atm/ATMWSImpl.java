package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.exception.StorageException;
import org.otus.hw07.atm.storage.Storage;

import java.util.Arrays;
import java.util.Collection;

public class ATMWSImpl implements ATMWS {
    private Storage storage;
    private AlgorithmIssuingBanknotes algorithm;

    public ATMWSImpl(Storage storage, AlgorithmIssuingBanknotes algorithm) {
        this.storage = storage;
        this.algorithm = algorithm;
    }

    @Override
    public void inputBanknote(Banknote... banknote) {
        Arrays.stream(banknote).forEach(b -> {
            try {
                this.storage.addBanknote(b);
            } catch (StorageException e) {
                e.printStackTrace();
                //TODO !!!!!!!!!!
            }
        });
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
        return null;
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
