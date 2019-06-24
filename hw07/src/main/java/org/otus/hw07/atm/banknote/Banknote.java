package org.otus.hw07.atm.banknote;

public interface Banknote extends Cloneable {
    public Nominal getNominal();

    public Object clone() throws CloneNotSupportedException;
}
