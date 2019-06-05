package org.otus.hw07.atm.banknote;

public class BanknoteNominal100 implements Banknote {
    private Nominal nominal = Nominal.NOMINAL_100;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }
}
