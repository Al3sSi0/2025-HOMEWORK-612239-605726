package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class ComandoVaiTest {
	private Partita partita;
	private Comando comando;
	private String direzione;
	
	@BeforeEach
	public void SetUp() {
		partita = new Partita();
		direzione = null;
		comando = new ComandoVai(direzione);
	}
	
	@Test
	public void testEseguiNull() {
		comando.esegui(partita);
		assertEquals(partita.getLabirinto().getStanzaCorrente().getNome(), "Atrio");
	}
	
	@Test
	public void testEseguiRandom() {
		comando.esegui(partita);
		assertNull(partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente("RANDOM"));
	}
	
	@Test
	public void testEsegui() {
		comando.setParametro("nord");
		comando.esegui(partita);
		assertEquals(partita.getLabirinto().getStanzaCorrente().getNome(), "Biblioteca");
	}
	

}
