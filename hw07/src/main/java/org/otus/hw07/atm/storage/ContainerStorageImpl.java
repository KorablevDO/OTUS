package org.otus.hw07.atm.storage;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.StorageException;

import java.util.List;
import java.util.Map;

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
    public List<Banknote> getBanknotes() {
        return null;
    }

    @Override
    public int getBalance() {
        return this.containers.stream().mapToInt(BanknotesСontainer::getCountBanknotes).sum();
    }

    @Override
    public Map<Integer, Integer> getContentsInfo() {

        return null;
    }
}
