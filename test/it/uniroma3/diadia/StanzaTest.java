package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class StanzaTest{
	private Stanza atrio;
	private Stanza n10;
	private Stanza n11;
	private Attrezzo lanterna;
	private Attrezzo osso;
	
	@BeforeEach
	public void Setup() {
		atrio = new Stanza("atrio");
		n11 = new Stanza("n11");
		n10 = new Stanza("n10");
		lanterna = new Attrezzo("lanterna", 3);
		osso = new Attrezzo("osso", 1);	
	}
	
	@Test
	public void testImpostaStanzaAdiacenteNull() {
		atrio.impostaStanzaAdiacente("nord", null);
		assertNull(atrio.getStanzaAdiacente("nord"));
	}	
	
	@Test
	public void testImpostaStanzaAdiacenteAtrio() {
		n10.impostaStanzaAdiacente("est", n11);
		assertEquals(n10.getStanzaAdiacente("est"), n11);
	}
	
	@Test
	public void testImpostaStanzaAdiacenteDoppia() {
		atrio.impostaStanzaAdiacente("est", n11);
		atrio.impostaStanzaAdiacente("sud", n10);
		assertEquals(atrio.getStanzaAdiacente("est"), n11);
		assertEquals(atrio.getStanzaAdiacente("sud"), n10);	
	}
	
	@Test 
	public void testAddAttrezzoNull() {
		n10.addAttrezzo(null);
		assertFalse(n10.addAttrezzo(null));
	}
	
	@Test 
	public void testAddAttrezzoSingolo() {
		n10.addAttrezzo(lanterna);
		assertTrue(n10.addAttrezzo(lanterna));
	}
	
	@Test 
	public void testAddAttrezzoDieci() {
		for(int i=0; i<10; i++) {
			n10.addAttrezzo(osso);
		}
		assertFalse(n10.addAttrezzo(osso));
	}
	
	@Test 
	public void testHasAttrezzoNull() {
		assertFalse(n10.hasAttrezzo(null));;		
	}
	
	@Test 
	public void testHasAttrezzoTrue() {
		n10.addAttrezzo(osso);
		assertTrue(n10.hasAttrezzo("osso"));;		
	}
	
	@Test 
	public void testHasAttrezzoFalse() {
		n10.addAttrezzo(osso);
		assertFalse(n10.hasAttrezzo("Mario"));	
	}

}

