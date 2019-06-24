package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.storage.Storage;

import java.util.Collection;

public interface ATMWS extends ATM {
    public void setStorage(Storage storage);

    public void setAlgorithm(AlgorithmIssuingBanknotes algorithm);

    public SnapshotATM createSnapshotATM() throws CloneNotSupportedException;
}
