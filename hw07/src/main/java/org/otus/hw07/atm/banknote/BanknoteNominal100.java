package org.otus.hw07.atm.banknote;

public class BanknoteNominal100 implements Banknote, Cloneable {
    private Nominal nominal = Nominal.NOMINAL_100;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
