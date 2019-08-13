package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.StorageException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ContainerStorageImpl implements Storage {
    private List<BanknotesСontainer> containers;

    public ContainerStorageImpl(List<BanknotesСontainer> containers){
        this.containers = containers;
    }

    @Override
    public void addBanknote(Banknote banknote) throws StorageException {
        for(BanknotesСontainer container : this.containers){
            if(container.isNominal(banknote.getNominal())){
                container.addBanknote(banknote);
                return;
            }
        }
    }

    @Override
    public List<Banknote> getBanknotes(Map<Integer, Integer> map) {
        List<Banknote> result = new ArrayList<>();

        for(Map.Entry entry : map.entrySet()) {
            int nominal = (int) entry.getKey();
            int number = (int) entry.getValue();

            for(BanknotesСontainer container : this.containers){
                if(container.getNominal() == nominal) {
                    for(int i = 0; i < number; i++){
                        result.add(container.removeBanknote());
                    }
                }
            }
        }
        return result;
    }

    @Override
    public int getBalance() {
        return this.containers.stream().mapToInt(value -> value.getCountBanknotes() * value.getNominal()).sum();
    }

    @Override
    public Map<Integer, Integer> getContentsInfo() {
        return this.containers.stream().collect(Collectors.toMap(BanknotesСontainer::getNominal, BanknotesСontainer::getCountBanknotes));
    }
}
