package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.storage.Storage;

public class SnapshotATM {
    private final ATMWS atm;
    private final Storage storage;
    private final AlgorithmIssuingBanknotes algorithm;

    public SnapshotATM(ATMWS atm, Storage storage, AlgorithmIssuingBanknotes algorithm){
        this.atm = atm;
        this.storage = storage;
        this.algorithm = algorithm;
    }

    public void restore(){
        this.atm.setStorage(this.storage);
        this.atm.setAlgorithm(this.algorithm);
    }
}
