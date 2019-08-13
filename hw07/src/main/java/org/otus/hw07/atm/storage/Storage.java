package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.BanknotesContainerException;
import org.otus.hw07.atm.exception.StorageException;

import java.util.List;
import java.util.Map;

public interface Storage {
    public void addBanknote(Banknote banknote) throws StorageException;

    public List<Banknote> getBanknotes(Map<Integer, Integer> map);

    public int getBalance();

    public Map<Integer, Integer> getContentsInfo();
}
