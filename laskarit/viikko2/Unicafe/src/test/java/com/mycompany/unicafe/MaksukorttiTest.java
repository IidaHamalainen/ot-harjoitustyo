package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    @Test
    public void konstruktoriAsettaaSaldon() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test
    public void lataaRahaaToimii() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }
    @Test
    public void otaRahaaToimii() {
        kortti.lataaRahaa(500);
        kortti.otaRahaa(250);
        assertEquals("saldo: 2.60", kortti.toString());
    }
    @Test
    public void eiVieSaldoaNegatiiviseksi() {
       kortti.otaRahaa(50);
       assertEquals("saldo: 0.10", kortti.toString());
    }
    @Test
    public void rahatRiittaaPalauttaaTrue() {
        boolean vastaus = kortti.otaRahaa(9);
        assertEquals(true, vastaus);
    }
    @Test
    public void rahatEiRiitaPalauttaaFalse() {
        boolean vastaus = kortti.otaRahaa(11);
        assertEquals(false, vastaus);
    }
    @Test
    public void saldoPalauttaaOikeanSaldon() {
        assertEquals(10, kortti.saldo());
    }
}
