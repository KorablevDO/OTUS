package org.otus.hw07.atm.banknote;

public class BanknoteImpl implements Banknote {
    private final Nominal nominal;

    public BanknoteImpl(Nominal nominal){
        this.nominal = nominal;
    }

    @Override
    public Nominal getNominal() {
        return this.nominal;
    }
}
