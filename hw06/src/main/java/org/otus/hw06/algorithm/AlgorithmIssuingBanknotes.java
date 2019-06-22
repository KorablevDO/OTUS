package org.otus.hw06.algorithm;

import org.otus.hw06.banknote.Nominal;
import org.otus.hw06.exception.BalanceException;

import java.util.Map;
import java.util.Set;

public interface AlgorithmIssuingBanknotes {
    public void setGivenNumber(int value);
    public void setNominal(Map<Nominal, Integer> map);
    public Map<Nominal, Integer> getPayment() throws BalanceException;
}
