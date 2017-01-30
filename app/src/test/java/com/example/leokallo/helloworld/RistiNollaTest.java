package com.example.leokallo.helloworld;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by leokallo on 19.10.2016.
 */

public class RistiNollaTest {

    @Test
    public void vuoroVaihtuu() {
        Logiikka logiikka = new Logiikka();
        assertEquals(true, logiikka.ristinVuoro());
        logiikka.vuoronVaihto();
        assertEquals(false, logiikka.ristinVuoro());
        logiikka.vuoronVaihto();
        assertEquals(true, logiikka.ristinVuoro());
    }
}
