package org.otus.hw07.atm.banknote;

public class BanknoteNominal50 implements Banknote, Cloneable {
    private Nominal nominal = Nominal.NOMINAL_50;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
