package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.banknote.Nominal;

import java.util.List;

/**
 *
 */
public class Сontainer {
    private Nominal nominal;
    private List<Banknote> banknoteList;

    public Nominal getNominal() {
        return nominal;
    }

    public void setNominal(Nominal nominal) {
        this.nominal = nominal;
    }

    public List<Banknote> getBanknoteList() {
        return banknoteList;
    }

    public void setBanknoteList(List<Banknote> banknoteList) {
        this.banknoteList = banknoteList;
    }

    @Override
    public boolean equals(Object obj) {
        Banknote banknote = (Banknote)obj;
        return banknote.getNominal().equals(nominal);
    }
}
