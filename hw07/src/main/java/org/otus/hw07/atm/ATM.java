package org.otus.hw07.atm;

import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;
import org.otus.hw07.atm.exception.StorageException;

import java.util.Collection;

public interface ATM {
    public void inputBanknote(Banknote... banknotes) throws ATMException;

    public Collection<Banknote> outputBanknote(int value) throws ATMException;

    public int getBalance();
}
