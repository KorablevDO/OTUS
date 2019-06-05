package org.otus.hw07.atm.algorithm;


import org.otus.hw07.atm.banknote.Nominal;
import org.otus.hw07.atm.exception.BalanceException;

import java.util.*;

public class AlgorithmIssuingBanknotesImpl implements AlgorithmIssuingBanknotes {

    @Override
    public Map<Nominal, Integer> getPayment(int value, Map<Nominal, Integer> map) throws BalanceException {
        Map<Nominal, Integer> storage = reversOrder(map);
        Map<Nominal, Integer> result = new HashMap<>();

        int i = 0;
        for (Map.Entry entry : storage.entrySet()) {
            int size = (int) entry.getValue();
            Nominal number = (Nominal) entry.getKey();

            while (true) {
                if (size > 0) {
                    int e = i + number.getValue();
                    if (e <= value) {
                        i = e;
                        size--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            result.put(number, (int) entry.getValue() - size);
        }

        if (i == value) {
            return result;
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
