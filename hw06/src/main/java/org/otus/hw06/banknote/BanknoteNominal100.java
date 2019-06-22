package org.otus.hw06.banknote;

public class BanknoteNominal100 implements Banknote {
    private Nominal nominal = Nominal.NOMINAL_100;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }
}
