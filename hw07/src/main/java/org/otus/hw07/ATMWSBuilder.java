package org.otus.hw07;

import org.otus.hw07.atm.ATMWS;
import org.otus.hw07.atm.ATMWSImpl;
import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.storage.BanknotesСontainer;
import org.otus.hw07.atm.storage.ContainerStorageImpl;
import org.otus.hw07.atm.storage.Storage;

import java.util.ArrayList;
import java.util.List;

public class ATMWSBuilder {
    private List<BanknotesСontainer> container = new ArrayList<>();
    private AlgorithmIssuingBanknotes algorithmIssuingBanknotes;

    public ATMWSBuilder setBanknotes(int nominal, int number){
        List<Banknote> banknotes = new ArrayList<>();
        for(int i = 0; i < number; i++) {
            banknotes.add(new Banknote(nominal));
        }
        this.container.add(new BanknotesСontainer(nominal, banknotes));
        return this;
    }


    public ATMWSBuilder setAlgorithmIssuingBanknotes(AlgorithmIssuingBanknotes algorithmIssuingBanknotes){
        this.algorithmIssuingBanknotes = algorithmIssuingBanknotes;
        return this;
    }

    public ATMWS build(){
        return new ATMWSImpl(new ContainerStorageImpl(this.container), this.algorithmIssuingBanknotes);
    }
}
