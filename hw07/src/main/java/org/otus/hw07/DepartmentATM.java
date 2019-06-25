package org.otus.hw07;

import org.otus.hw07.atm.ATM;
import org.otus.hw07.atm.ATMWS;
import org.otus.hw07.atm.SnapshotATM;

import java.util.ArrayList;
import java.util.List;

public class DepartmentATM {
    private List<ATMWS> atmList;
    private List<SnapshotATM> backup;

    {
        this.atmList = new ArrayList<>();
        this.backup = new ArrayList<>();
    }

    public void addATM(ATMWS atm){
        this.atmList.add(atm);
        this.backup.add(atm.createSnapshotATM());
    }

    public int getAllRemainingSumInATMs(){
       return  this.atmList.stream().mapToInt(ATMWS::getBalance).sum();
    }

    public void restoreOriginalStateATMs(){
        this.backup.forEach(SnapshotATM::restore);
    }
}
