package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.banknote.Nominal;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class BanknotesСontainer implements Cloneable{
    private final Nominal nominal;
    private List<Banknote> banknoteList;

    public BanknotesСontainer(Nominal nominal){
        this.nominal = nominal;
    }

    public Nominal getNominal() {
        return nominal;
    }

    public List<Banknote> getBanknoteList() {
        if(this.banknoteList == null){
            this.banknoteList = new ArrayList<>();
        }
        return banknoteList;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Banknote) {
            Banknote banknote = (Banknote) obj;
            return banknote.getNominal().equals(nominal);
        } else {
            return false;
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
