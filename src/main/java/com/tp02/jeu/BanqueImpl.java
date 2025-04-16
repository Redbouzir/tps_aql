package com.tp02.jeu;

public class BanqueImpl implements Banque {
    private int fond;
    private final int fondMinimum;

    public BanqueImpl(int fondInitial, int fondMinimum) {
        this.fond = fondInitial;
        this.fondMinimum = fondMinimum;
    }

    @Override
    public void crediter(int somme) {
        this.fond += somme;
    }

    @Override
    public boolean est_solvable() {
        return this.fond >= this.fondMinimum;
    }

    @Override
    public void debiter(int somme) {
        this.fond -= somme;
    }

    public int getFond() {
        return fond;
    }
} 