package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoPosa;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class ComandoPosaTest {
	private String nomeAttrezzo;
	private Partita partita;
	private Comando comando;
	
	@BeforeEach
	public void SetUp() {
		nomeAttrezzo = null;
		partita = new Partita();
		comando = new ComandoPosa(nomeAttrezzo);
	}
	
	@Test
	public void testEseguiRandom() {
		partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo("osso"));
		comando.setParametro("RANDOM");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().isEmpty());		
	}
	
	@Test
	public void testEsegui() {
		partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo("osso"));
		comando.setParametro("osso");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().isEmpty());
	}	
}