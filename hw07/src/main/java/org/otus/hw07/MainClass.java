package org.otus.hw07;

import org.otus.hw07.atm.ATMWS;
import org.otus.hw07.atm.banknote.Banknote;
import org.otus.hw07.atm.exception.ATMException;

public class MainClass {
    public static void main(String[] args) throws ATMException {
        ATMWS atm1 = ATMWSFactory.createATMS();
        ATMWS atm2 =  ATMWSFactory.createATMS();

        DepartmentATM departmentATM = new DepartmentATM();
        departmentATM.addATM(atm1);
        departmentATM.addATM(atm2);
        departmentATM.createSnapshotATMs();

        System.out.println(atm1.getBalance());
        System.out.println(atm2.getBalance());
        System.out.println(departmentATM.getAllRemainingSumInATMs());

        atm1.outputBanknote(1750);
        atm2.outputBanknote(2250);

        System.out.println(atm1.getBalance());
        System.out.println(atm2.getBalance());
        System.out.println(departmentATM.getAllRemainingSumInATMs());

        atm1.inputBanknote(new Banknote(500), new Banknote(50));
        atm2.inputBanknote(new Banknote(500), new Banknote(50));

        System.out.println(atm1.getBalance());
        System.out.println(atm2.getBalance());
        System.out.println(departmentATM.getAllRemainingSumInATMs());

        departmentATM.restoreOriginalStateATMs();

        System.out.println(atm1.getBalance());
        System.out.println(atm2.getBalance());
        System.out.println(departmentATM.getAllRemainingSumInATMs());
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