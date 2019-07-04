package org.otus.hw07;

import org.otus.hw07.atm.ATMWSImpl;
import org.otus.hw07.atm.algorithm.AlgorithmIssuingBanknotesImpl;
import org.otus.hw07.atm.storage.ContainerStorageImpl;

public class MainClass {
    public static void main(String[] args) {
        DepartmentATM departmentATM = new DepartmentATM();
        departmentATM.addATM(new ATMWSImpl(new ContainerStorageImpl(null), new AlgorithmIssuingBanknotesImpl()));
        System.out.println(departmentATM.getAllRemainingSumInATMs());
        departmentATM.restoreOriginalStateATMs();
    }

    /**
     * Паттерн Компоновщик использую в хранении банкнот.
     */
}

/**
 * 1. Strategy
 * 2. Iterator
 * 3. Facade
 * 4. Flyweight
 * 5. Bridge
 * 6. Composite
 *
 *
 * 1. задать вопрос про паттерн
 * 2. задать вопрос про структуру данных
 * 3. задать вопрос про алгоритм
 */