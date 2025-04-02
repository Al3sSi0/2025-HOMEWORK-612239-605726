package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class PartitaTest {
	private Partita partita;
	private Labirinto labirinto;
	
	@BeforeEach
	public void Setup() {
		partita = new Partita();
		labirinto = partita.getLabirinto();
	}
	
	@Test
	public void testVintaTrue() {
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(partita.vinta());	
	}
	
	@Test
	public void testVintaFalse() {
		assertFalse(partita.vinta());	
	}
	
	@Test
	public void testVintaNull() {
		labirinto.setStanzaCorrente(null);
		assertFalse(partita.vinta());	
	}
	
	@Test
	public void testIsFinita() {
		partita.setFinita();
		assertTrue(partita.isFinita());		
	}
	
	@Test
	public void testIsFinitaVinta() {
		labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
		assertTrue(partita.isFinita());		
	}
	
	@Test
	public void testIsFinitaCfu() {
		partita.getGiocatore().setCfu(0);
		assertTrue(partita.isFinita());		
	}

}


