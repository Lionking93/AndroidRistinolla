package com.example.leokallo.helloworld;

/**
 * Created by leokallo on 19.10.2016.
 */

public class Koordinaatti {
    private int i;
    private int j;

    public Koordinaatti(String ruutuId) {
        if (ruutuId.equals("first_square")) {
            this.i = 0;
            this.j = 0;
        } else if(ruutuId.equals("second_square")) {
            this.i = 0;
            this.j = 1;
        } else if(ruutuId.equals("third_square")) {
            this.i = 0;
            this.j = 2;
        } else if (ruutuId.equals("fourth_square")) {
            this.i = 1;
            this.j = 0;
        } else if (ruutuId.equals("fifth_square")) {
            this.i = 1;
            this.j = 1;
        } else if (ruutuId.equals("sixth_square")) {
            this.i = 1;
            this.j = 2;
        } else if(ruutuId.equals("seventh_square")) {
            this.i = 2;
            this.j = 0;
        } else if (ruutuId.equals("eighth_square")) {
            this.i = 2;
            this.j = 1;
        } else {
            this.i = 2;
            this.j = 2;
        }
    }

    public int getI() {
        return this.i;
    }

    public int getJ() {
        return this.j;
    }
}
