package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;




class LabirintoTest {
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private Stanza stanzaVincente;
	
	@BeforeEach
	public void Setup() {
		labirinto = new Labirinto();
		stanzaCorrente = labirinto.getStanzaCorrente();
		stanzaVincente = labirinto.getStanzaVincente();
	}
	
	@Test
	public void testGetStanzaCorrente() {
		assertEquals(stanzaCorrente, labirinto.getStanzaCorrente());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(stanzaVincente, labirinto.getStanzaVincente());
	}

}
