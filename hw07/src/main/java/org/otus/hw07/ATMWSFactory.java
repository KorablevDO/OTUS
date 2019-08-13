package org.otus.hw07;

import org.otus.hw07.atm.ATMWS;
import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotesImpl;

public class ATMWSFactory {
    public static ATMWS createATMS(){
        return new ATMWSBuilder()
                .setAlgorithmIssuingBanknotes(new AlgorithmIssuingBanknotesImpl())
                .setBanknotes(50, 5)
                .setBanknotes(100, 5)
                .setBanknotes(500, 5)
                .setBanknotes(1000, 5)
                .build();
    }
}
