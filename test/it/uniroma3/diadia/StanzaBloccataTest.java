package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class StanzaBloccataTest {
	private Stanza stanza;
	private Stanza stanza2;	
	private String dirBloccata;
	private Attrezzo pass;
	
	@BeforeEach
	public void SetUp() {
		stanza = new StanzaBloccata("atrio");
		stanza2 = new StanzaBloccata("N10");
		dirBloccata = "est";
		pass = new Attrezzo("passepartout", 1);
	}
	
	@Test
	public void testGetStanzaAdiacenteNull() {
		assertNull(stanza.getStanzaAdiacente(dirBloccata));
	}
	
	@Test 
	public void testGetStanzaAdiacente() {
		stanza.addAttrezzo(pass);
		stanza.impostaStanzaAdiacente("est", stanza2);
		assertEquals(stanza.getStanzaAdiacente(dirBloccata).getNome(), stanza2.getNome());
	}
	
	@Test
	public void testGetDescrzioneNull() {
		assertEquals(stanza.getDescrizione(), "La stanza ha la direzione est bloccata!");
	}
	
	@Test 
	public void testGetDescrzione() {
		stanza.addAttrezzo(pass);
		assertNotEquals(stanza.getDescrizione(), "La stanza ha la direzione est bloccata!" );
	}
}
