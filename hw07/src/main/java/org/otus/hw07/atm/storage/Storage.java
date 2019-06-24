package org.otus.hw07.atm.storage;


import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.banknote.Nominal;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Storage extends Cloneable{
    public void addBanknote(Banknote banknote);

    public List<Banknote> getBanknotes(Map<Nominal, Integer> map);

    public int getBalance();

    public Map<Nominal, Integer> getContentsInfo();

    public Object clone() throws CloneNotSupportedException;
}
