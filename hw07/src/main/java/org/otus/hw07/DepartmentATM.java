package org.otus.hw07;

import org.otus.hw07.atm.ATMWS;
import org.otus.hw07.atm.SnapshotATM;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DepartmentATM {
    private List<ATMWS> atmList;
    private List<SnapshotATM> backup;

    {
        this.atmList = new ArrayList<>();
    }

    public void addATM(ATMWS atm){
        this.atmList.add(atm);
    }

    public void createSnapshotATMs(){
        this.backup = this.atmList.stream().map(ATMWS::createSnapshotATM).collect(Collectors.toList());
    }

    public int getAllRemainingSumInATMs(){
       return this.atmList.stream().mapToInt(ATMWS::getBalance).sum();
    }

    public void restoreOriginalStateATMs(){
        this.backup.forEach(SnapshotATM::restore);
    }
}
