package com.example.leokallo.helloworld;

/**
 * Created by leokallo on 19.10.2016.
 */

public class Logiikka {
    private boolean ristinVuoro;
    private String[][] ruudukko;
    private int moneskoSiirto;
    private String pelinTulos;

    public Logiikka() {
        this.pelinTulos = "";
        this.moneskoSiirto = 0;
        this.ruudukko = new String[3][3];
        this.ristinVuoro = true;
        alustaRuudukko();
    }

    public boolean ristinVuoro() {
        return this.ristinVuoro;
    }

    public String getPelinTulos() {
        return this.pelinTulos;
    }

    public void vuoronVaihto() {
        this.ristinVuoro = !this.ristinVuoro;
        this.moneskoSiirto++;
    }

    public String peliSiirto(Koordinaatti k) {
        if (pelinTulos.isEmpty()) {
            if (this.ristinVuoro) {
                if (this.ruudukko[k.getI()][k.getJ()].isEmpty()) {
                    vuoronVaihto();
                    return this.ruudukko[k.getI()][k.getJ()] = "X";
                }
            } else {
                if (this.ruudukko[k.getI()][k.getJ()].isEmpty()) {
                    vuoronVaihto();
                    return this.ruudukko[k.getI()][k.getJ()] = "O";
                }
            }
        }
        return this.ruudukko[k.getI()][k.getJ()];
    }

    public boolean peliPaattyi() {
        if (ristiVoitti()) {
            this.pelinTulos = "Risti voitti!";
            return true;
        } else if (nollaVoitti()) {
            this.pelinTulos = "Nolla voitti!";
            return true;
        } else {
            if (this.moneskoSiirto == 9) {
                this.pelinTulos = "Tasapeli";
                return true;
            } else {
                return false;
            }
        }
    }

    public boolean ristiVoitti() {
        if (vaakarivit("X") || pystyrivit("X") || viistot("X")) {
            return true;
        }
        return false;
    }

    public boolean nollaVoitti() {
        if (vaakarivit("O") || pystyrivit("O") || viistot("O")) {
            return true;
        }
        return false;
    }

    public boolean vaakarivit(String symboli) {
        for (int i = 0; i < 3; i++) {
            int montakoSymbolia = 0;
            for (int j = 0; j < 3; j++) {
                if (this.ruudukko[i][j].equals(symboli)) {
                    montakoSymbolia++;
                }
            }
            if (montakoSymbolia == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean pystyrivit(String symboli) {
        for (int j = 0; j < 3; j++) {
            int montakoSymbolia = 0;
            for (int i = 0; i < 3; i++) {
                if (this.ruudukko[i][j].equals(symboli)) {
                    montakoSymbolia++;
                }
            }
            if (montakoSymbolia == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean viistot(String symboli) {
        int montakoSymbolia = 0;
        for (int i = 0; i < 3; i++) {
            if (this.ruudukko[i][i].equals(symboli)) {
                montakoSymbolia++;
            }
        }
        if (montakoSymbolia == 3) {
            return true;
        }
        montakoSymbolia = 0;
        for (int i = 2; i >= 0; i--) {
            if (this.ruudukko[2-i][i].equals(symboli)) {
                montakoSymbolia++;
            }
        }
        if (montakoSymbolia == 3) {
            return true;
        }
        return false;
    }

    public void alustaRuudukko() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.ruudukko[i][j] = "";
            }
        }
    }
}
