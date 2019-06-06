package org.otus.hw07;

import org.otus.hw07.atm.ATM;
import org.otus.hw07.atm.ATMFactori;
import org.otus.hw07.atm.exception.ATMException;

public class MainClass {
    public static void main(String[] args) throws ATMException {
        DepartmentATM departmentATM = new DepartmentATM();
        ATM atm1 = ATMFactori.standartATM();
        departmentATM.addATM(atm1);
        System.out.println("atm1: " + atm1.getBalance());
        ATM atm2 = ATMFactori.standartATM();
        departmentATM.addATM(atm2);
        System.out.println("atm2: " + atm2.getBalance());
        ATM atm3 = ATMFactori.containerStorageATM();
        departmentATM.addATM(atm3);
        System.out.println("atm3: " + atm3.getBalance());
        ATM atm4 = ATMFactori.containerStorageATM();
        departmentATM.addATM(atm4);
        System.out.println("atm4: " + atm4.getBalance());
        System.out.println("sum: " + departmentATM.getAllRemainingSumInATMs());

        atm1.outputBanknote(1000);
        atm2.outputBanknote(3300);
        atm2.outputBanknote(350);
        atm3.outputBanknote(1000);
        atm4.outputBanknote(3300);
        atm4.outputBanknote(350);


        System.out.println("sum: " + departmentATM.getAllRemainingSumInATMs());

        departmentATM.restoreOriginalStateATMs();
        System.out.println("sum: " + departmentATM.getAllRemainingSumInATMs());
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