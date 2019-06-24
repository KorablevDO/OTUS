package org.otus.hw07.atm.banknote;

public class BanknoteNominal500 implements Banknote, Cloneable {
    private Nominal nominal = Nominal.NOMINAL_500;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
