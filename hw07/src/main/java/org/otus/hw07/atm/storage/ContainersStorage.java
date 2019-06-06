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
        BanknotesСontainer container = this.storage.stream().filter(p -> p.getNominal().equals(banknote.getNominal())).collect(Collectors.toList()).get(0);
        container.getBanknoteList().add(banknote);
    }

    @Override
    public List<Banknote> getBanknotes(Map<Nominal, Integer> map) {
        List<Banknote> result = new ArrayList<>();
        for (var entry : map.entrySet()){
            BanknotesСontainer container =  this.storage.stream().filter(p -> p.getNominal().equals(entry.getKey())).collect(Collectors.toList()).get(0);
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
        return this.storage.stream().mapToInt(p -> p.getBanknoteList().size()*p.getNominal().getValue()).sum();
    }

    @Override
    public Map<Nominal, Integer> getContentsInfo() {
        return this.storage.stream().collect(Collectors.toMap(p->p.getNominal(),p->p.getBanknoteList().size()));
    }
}
