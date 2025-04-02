package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class GiocatoreTest {
	private Giocatore giocatore;
	private Borsa borsa;
	
	@BeforeEach
	public void Setup() {
		giocatore = new Giocatore();
		borsa = giocatore.getBorsa();
	}
	
	
	@Test
	public void testSetCfu() {
		giocatore.setCfu(20);
		assertEquals(giocatore.getCfu(), 20);
	}	
	
	@Test
	public void testGetBorsa() {
		assertEquals(borsa, giocatore.getBorsa());
	}
}
