package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.BanknotesContainerException;
import org.otus.hw07.atm.exception.StorageException;

import java.util.ArrayList;
import java.util.List;

public class BanknotesСontainer {
    private int formatNominal;
    private List<Banknote> list;

    public BanknotesСontainer(int nominal){
        this.formatNominal = nominal;
        this.list = new ArrayList<>();
    }

    public BanknotesСontainer(int nominal, List<Banknote> list){
        this.formatNominal = nominal;
        this.list = list;
    }

    public void addBanknote(Banknote banknote) throws BanknotesContainerException {
        if(this.isNominal(banknote.getNominal())) {
            this.list.add(banknote);
        } else {
            throw new BanknotesContainerException("Set is not valid formatNominal banknote");
        }
    }

    public Banknote removeBanknote(){
        return this.list.remove(0);
    }

    public int getCountBanknotes(){
        return this.list.size();
    }

    public boolean isNominal(int nominal){
        return this.formatNominal == nominal;
    }
}
