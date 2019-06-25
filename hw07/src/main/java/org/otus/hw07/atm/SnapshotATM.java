package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.storage.Storage;

public class SnapshotATM {
    private final ATMWS atm;

    public SnapshotATM(ATMWS atm, Storage storage, AlgorithmIssuingBanknotes algorithm){
        this.atm = atm;
    }

    public void restore(){
        this.atm.setStorage(null);
        this.atm.setAlgorithm(null);
    }
}
