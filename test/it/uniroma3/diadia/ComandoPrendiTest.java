package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPrendi;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class ComandoPrendiTest {
	private Partita partita;
	private Comando comando;
	private String nomeAttrezzo;
	
	@BeforeEach
	public void SetUp() {
		partita = new Partita();
		nomeAttrezzo = null;
		comando = new ComandoPrendi(nomeAttrezzo);
	}
	
	@Test 
	public void testEseguiRandom() {
		comando.setParametro("RANDOM");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());		
	}
	
	@Test
	public void testEsegui() {
		comando.setParametro("osso");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().isEmpty());
	}
	

}
