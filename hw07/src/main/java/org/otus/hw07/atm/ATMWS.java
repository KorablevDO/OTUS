package org.otus.hw07.atm;

import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotes;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.storage.Storage;

import java.util.Collection;
import java.util.Optional;

/**
 * Применяю паттерн Декоратор, для расширения функционала класса ATM
 */
public class ATMWS extends ATMIpl {
    private final SnapshotATM snapshotATM;

    public ATMWS(Storage storage, AlgorithmIssuingBanknotes algorithm) {
        super(storage, algorithm);
        this.snapshotATM = new SnapshotATM();
    }

    @Override
    public void inputBanknote(Banknote... banknote) {
        if(Optional.ofNullable(banknote).isPresent()) {
            if (banknote.length > 0) {
                super.inputBanknote(banknote);
            }
        }
    }

    @Override
    public Collection<Banknote> outputBanknote(int value) throws ATMException {
        if (value > 0) {
            return super.outputBanknote(value);
        }
        return null;
    }

    @Override
    public int getBalance() {
        return super.getBalance();
    }

    public SnapshotATM getSnapshotATM(){
        return this.snapshotATM;
    }
}
