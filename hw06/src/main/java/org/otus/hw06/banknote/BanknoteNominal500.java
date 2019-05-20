package org.otus.hw06.banknote;

public class BanknoteNominal500 implements Banknote {
    private Nominal nominal = Nominal.NOMINAL_500;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }
}
