package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class FabbricaDiComandiFisarmonicaTest {
	private FabbricaDiComandiFisarmonica fabbrica;
	private Comando comando;
	private String parametro;
	
	@BeforeEach
	public void SetUp() {
		fabbrica = new FabbricaDiComandiFisarmonica();
	}
	
	
	@Test
	public void testAiuto() {
		assertEquals(fabbrica.costruisciComando("aiuto").getNome(), "aiuto");
	}
	
	
	@Test
	public void testFine() {
		assertEquals(fabbrica.costruisciComando("fine").getNome(), "fine");
	}
	
	
	@Test
	public void testGuarda() {
		assertEquals(fabbrica.costruisciComando("guarda").getNome(), "guarda");
	}
	
	
	@Test
	public void testComandoNonValido() {
		assertEquals(fabbrica.costruisciComando("RANDOM").getNome(), "comando non valido");
	}
	
	
	@Test
	public void testPosa() {
		assertEquals(fabbrica.costruisciComando("posa").getNome(), "posa");
	}
	
	
	@Test
	public void testPrendi() {
		assertEquals(fabbrica.costruisciComando("prendi").getNome(), "prendi");
	}
	
	
	@Test
	public void testVai() {
		assertEquals(fabbrica.costruisciComando("vai").getNome(), "vai");
	}
	
	
}
