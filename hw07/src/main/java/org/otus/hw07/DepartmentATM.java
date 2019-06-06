package org.otus.hw07;

import org.otus.hw07.atm.ATM;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DepartmentATM {
    private List<ATM> atms = new ArrayList<>();

    public void addATM(ATM atm){
        this.atms.add(atm);
    }

    public int getAllRemainingSumInATMs(){
        return this.atms.stream().mapToInt(p ->p.getBalance()).sum();
    }

    public void restoreOriginalStateATMs(){

    }
}
