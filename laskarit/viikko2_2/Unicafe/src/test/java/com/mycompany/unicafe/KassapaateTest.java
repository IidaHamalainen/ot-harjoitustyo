
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class KassapaateTest {
    
    Kassapaate kassa;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
        int kassassaRahaa = 100000;
        int edulliset = 0;
        int maukkaat = 0;
    }
    @Test
    public void kassassaRahaaAlussa() {
        assertEquals(100000, kassa.kassassaRahaa());
    }
    @Test
    public void edullisiaMyytyAlussa() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());    
    }
    @Test
    public void maukkaitaMyytyAlussa() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKateisellaRahaRiittaa() {
        kassa.syoEdullisesti(300);
        assertEquals(100240, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKateisellaRahaEiRiita() {
        kassa.syoEdullisesti(200);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoMaukkaastiKateisellaRahaRiittaa() {
        kassa.syoMaukkaasti(500);
        assertEquals(100400, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoMaukkaastiKateisellaRahaEiRiita() {
        kassa.syoMaukkaasti(300);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiKortillaRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        
    }
    @Test
    public void syoMaukkaastiKortillaRahaa() {
        Maksukortti kortti = new Maksukortti(500);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());  
        
    }
    @Test
    public void syoMaukkaastiPalauttaaTrue() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(kassa.syoMaukkaasti(kortti));
    }
    @Test
    public void syoEdullisestiPalauttaaTrue() {
        Maksukortti kortti = new Maksukortti(500);
        assertTrue(kassa.syoEdullisesti(kortti));
    }
    @Test 
    public void syoEdullisestiKortillaRahaEiRiita() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.syoEdullisesti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
    }
    @Test
    public void syoEdullisestiPalauttaaFalse() {
        Maksukortti kortti = new Maksukortti(100);
        assertFalse(kassa.syoEdullisesti(kortti));
    
    }
    @Test
    public void syoMaukkaastiKortillaRahaEiRiita() {
        Maksukortti kortti = new Maksukortti(300);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty()); 
    }
    @Test
    public void syoMaukaastiPalauttaaFalse() {
        Maksukortti kortti = new Maksukortti(100);
        assertFalse(kassa.syoMaukkaasti(kortti));
    }
    @Test
    public void lataaKorttiaToimii() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.lataaRahaaKortille(kortti, 500);
        assertEquals(100500, kassa.kassassaRahaa());
    }
    @Test
    public void lataaKorttiaIlmanRahaa() {
        Maksukortti kortti = new Maksukortti(100);
        kassa.lataaRahaaKortille(kortti, -1);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
   

    
}
