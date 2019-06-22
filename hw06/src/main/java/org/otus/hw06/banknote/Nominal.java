package org.otus.hw06.banknote;

public enum Nominal {
    NOMINAL_10(10),
    NOMINAL_50(50),
    NOMINAL_100(100),
    NOMINAL_500(500);

    private final int value;

    Nominal(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }
}
