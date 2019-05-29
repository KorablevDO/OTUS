package org.otus.hw06.algorithm;

import org.otus.hw06.banknote.Nominal;
import org.otus.hw06.exception.BalanceException;

import java.util.*;

public class AlgorithmIssuingBanknotesImpl implements AlgorithmIssuingBanknotes {
    private int givenNumber;
    private Map<Nominal, Integer> map;

    @Override
    public void setGivenNumber(int value) {
        this.givenNumber = value;
    }

    @Override
    public void setNominal(Map<Nominal, Integer> map) {
        this.map = reversOrder(map);
    }

    @Override
    public Map<Nominal, Integer> getPayment() throws BalanceException {
        Map<Nominal, Integer> map = new HashMap<>();

        int i = 0;
        for (Map.Entry entry : this.map.entrySet()) {
            int size = (int) entry.getValue();
            Nominal number = (Nominal) entry.getKey();

            while (true) {
                if (size > 0) {
                    int e = i + number.getValue();
                    if (e <= this.givenNumber) {
                        i = e;
                        size--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            map.put(number, (int) entry.getValue() - size);
        }

        if (i == this.givenNumber) {
            return map;
        } else {
            throw new BalanceException("Невозможно выдать указанную сумму");
        }
    }

    private Map<Nominal, Integer> reversOrder(Map<Nominal, Integer> map) {
        Map<Nominal, Integer> revers = new TreeMap<>(Collections.reverseOrder());
        revers.putAll(map);
        return revers;
    }
}
