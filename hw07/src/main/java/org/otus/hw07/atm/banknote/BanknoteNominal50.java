package org.otus.hw07.atm.banknote;

public class BanknoteNominal50 implements Banknote {
    private Nominal nominal = Nominal.NOMINAL_50;

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }
}
