package org.otus.hw07.atm.algorithm;

import org.otus.hw07.atm.exception.AlgorithmIssuingBanknotesException;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class AlgorithmIssuingBanknotesImpl implements AlgorithmIssuingBanknotes{
    @Override
    public Map<Integer, Integer> getPayment(int value, Map<Integer, Integer> info) throws AlgorithmIssuingBanknotesException {
        Map<Integer, Integer> storage = reversOrder(info);
        Map<Integer, Integer> result = new HashMap<>();

        int i = 0;
        for (Map.Entry entry : storage.entrySet()) {
            int nominal = (int)entry.getKey();
            int number = (int)entry.getValue();

            while (true) {
                if (number > 0) {
                    int e = i + nominal;
                    if (e <= value) {
                        i = e;
                        number--;
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }

            result.put(nominal, (int) entry.getValue() - number);
        }

        if (i == value) {
            return result;
        } else {
            throw new AlgorithmIssuingBanknotesException("Невозможно выдать указанную сумму");
        }
    }

    private Map<Integer, Integer> reversOrder(Map<Integer, Integer> map) {
        Map<Integer, Integer> revers = new TreeMap<>(Collections.reverseOrder());
        revers.putAll(map);
        return revers;
    }
}
