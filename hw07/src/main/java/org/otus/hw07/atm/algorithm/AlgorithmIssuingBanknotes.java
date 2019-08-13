package org.otus.hw07.atm.algorithm;

import org.otus.hw07.atm.exception.AlgorithmIssuingBanknotesException;

import java.util.Map;

public interface AlgorithmIssuingBanknotes {
    public Map<Integer, Integer> getPayment(int value, Map<Integer, Integer> info) throws AlgorithmIssuingBanknotesException;
}
