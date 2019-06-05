package org.otus.hw07.atm.algorithm;


import org.otus.hw07.atm.banknote.Nominal;
import org.otus.hw07.atm.exception.BalanceException;

import java.util.Map;
import java.util.Set;

public interface AlgorithmIssuingBanknotes {
    public Map<Nominal, Integer> getPayment(int value, Map<Nominal, Integer> map) throws BalanceException;
}
