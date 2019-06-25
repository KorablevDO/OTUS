package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;

import java.util.List;

public interface Storage {
    public void addBanknote(Banknote banknote);

    public List<Banknote> getBanknotes();

    public int getBalance();

    public void getContentsInfo();
}
