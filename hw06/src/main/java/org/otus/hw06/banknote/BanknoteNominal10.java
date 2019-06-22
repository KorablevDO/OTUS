package org.otus.hw06.banknote;

public class BanknoteNominal10 implements Banknote {
    private Nominal nominal = Nominal.NOMINAL_10;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }
}
