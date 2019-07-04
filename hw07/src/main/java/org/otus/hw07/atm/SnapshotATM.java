package org.otus.hw07.atm;

import com.google.gson.Gson;
import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.storage.Storage;

public class SnapshotATM {
    private Gson gson = new Gson();
    private final ATMWS atm;
    private final String storageJson;
    private final Class aClass;
    private final AlgorithmIssuingBanknotes algorithm;

    public SnapshotATM(ATMWS atm, Storage storage, AlgorithmIssuingBanknotes algorithm){
        this.atm = atm;
        this.aClass = storage.getClass();
        this.storageJson = gson.toJson(storage, this.aClass);
        this.algorithm = algorithm;
    }

    public void restore(){
        this.atm.setStorage((Storage) gson.fromJson(this.storageJson, this.aClass));
        this.atm.setAlgorithm(this.algorithm);
    }
}
