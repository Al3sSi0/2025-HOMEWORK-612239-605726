package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class BorsaTest {
	private Borsa borsa;
	private Attrezzo attrezzo;
	private Attrezzo attrezzo2;
	
	@BeforeEach
	public void Setup() {
		borsa = new Borsa();
		attrezzo = new Attrezzo("ascia", 1);
		attrezzo2 = new Attrezzo("osso", 12);
	}
	
	@Test
	public void testAddAttrezzoTrue() {
		assertTrue(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testAddAttrezzoFalsePeso() {
		assertFalse(borsa.addAttrezzo(attrezzo2));
	}
	
	@Test
	public void testAddAttrezzoFalseFull() {
		for(int i=0; i<10; i++) {
			borsa.addAttrezzo(attrezzo);
		}
		assertFalse(borsa.addAttrezzo(attrezzo));
	}
	
	@Test
	public void testRemoveAttrezzoNull() {
		assertNull(borsa.removeAttrezzo(""));
	}
	
	@Test
	public void testRemoveAttrezzoNotNull() {
		borsa.addAttrezzo(attrezzo);
		assertNotNull(borsa.removeAttrezzo(attrezzo.getNome()));
	}
	
	
}
