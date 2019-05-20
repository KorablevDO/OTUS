package org.otus.hw06.storage;

import org.otus.hw06.banknote.Banknote;
import org.otus.hw06.banknote.Nominal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Storage {
    public void setBanknote(Banknote banknote);
    public List<Banknote> getBanknote(Map<Nominal, Integer> map);
    public int getBalance();
    public Map<Nominal, Integer> getNominal();
}
