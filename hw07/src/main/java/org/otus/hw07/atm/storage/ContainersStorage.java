package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.banknote.Nominal;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContainersStorage implements Storage{
    public Set<BanknotesСontainer> storage;

    public ContainersStorage(Set<BanknotesСontainer> containers){
        this.storage = new HashSet<>();
        this.storage.addAll(containers);
    }

    @Override
    public void addBanknote(Banknote banknote) {
        BanknotesСontainer container = (BanknotesСontainer) this.storage.stream().filter(banknote.getNominal()::equals);
        container.getBanknoteList().add(banknote);
    }

    @Override
    public List<Banknote> getBanknotes(Map<Nominal, Integer> map) {
        List<Banknote> result = new ArrayList<>();
        for (var entry : map.entrySet()){
            BanknotesСontainer container = (BanknotesСontainer) this.storage.stream().filter(entry.getKey()::equals);
            List<Banknote> banknotes = container.getBanknoteList();
            addBanknoteInList(result, banknotes, entry.getValue());
        }
        return result;
    }

    private void addBanknoteInList(List<Banknote> result,List<Banknote> banknotes, int number){
        for(int i = 0; i < number; i++){
            result.add(banknotes.remove(0));
        }
    }

    @Override
    public int getBalance() {
        return this.storage.stream().mapToInt(p -> p.getBanknoteList().size()).sum();
    }

    @Override
    public Map<Nominal, Integer> getContentsInfo() {
        return this.storage.stream().collect(Collectors.toMap(p->p.getNominal(),p->p.getBanknoteList().size()));
    }
}
