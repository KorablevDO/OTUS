package org.otus.hw07.atm.storage;


import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.banknote.Nominal;

import java.util.*;

public class StorageImpl implements Storage, Cloneable {
    private Map<Nominal, List<Banknote>> listMap;

    public StorageImpl() {
        this.listMap = new HashMap<>();
        this.listMap.put(Nominal.NOMINAL_10, new ArrayList<>());
        this.listMap.put(Nominal.NOMINAL_50, new ArrayList<>());
        this.listMap.put(Nominal.NOMINAL_100, new ArrayList<>());
        this.listMap.put(Nominal.NOMINAL_500, new ArrayList<>());
    }

    @Override
    public void addBanknote(Banknote banknote) {
        this.listMap.get(banknote.getNominal()).add(banknote);
    }

    @Override
    public List<Banknote> getBanknotes(Map<Nominal, Integer> map) {
        List<Banknote> result = new ArrayList<>();
        for (var entry : map.entrySet()) {
            List<Banknote> banknotes = listMap.get(entry.getKey());
            int number = entry.getValue();
            for (int i = 0; i < number; i++) {
                result.add(banknotes.remove(0));
            }
        }

        return result;
    }

    @Override
    public int getBalance() {
        return this.listMap.entrySet().stream().mapToInt(p -> p.getKey().getValue() * p.getValue().size()).sum();
    }

    @Override
    public Map<Nominal, Integer> getContentsInfo() {
        Map<Nominal, Integer> nominal = new HashMap<>();
        for (Map.Entry entry : this.listMap.entrySet()) {
            var list = (List) entry.getValue();
            nominal.put((Nominal) entry.getKey(), list.size());
        }
        return nominal;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
