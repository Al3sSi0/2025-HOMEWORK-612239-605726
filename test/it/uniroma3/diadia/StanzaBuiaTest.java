package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class StanzaBuiaTest {
	private Stanza stanza;
	private Attrezzo att;
		
	@BeforeEach
	public void SetUp() {
		stanza = new StanzaBuia("atrio");
		att = new Attrezzo("lanterna", 1);
	}
	
	@Test
	public void testGetDescrzioneNull() {
		assertEquals(stanza.getDescrizione(), "Qui c'è un buio pesto!");
	}
	
	@Test 
	public void testGetDescrzione() {
		stanza.addAttrezzo(att);
		assertNotEquals(stanza.getDescrizione(), "Qui c'è un buio pesto!" );
	}
	
}
