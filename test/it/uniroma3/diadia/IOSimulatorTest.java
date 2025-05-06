package it.uniroma3.diadia;import it.uniroma3.diadia.ambienti.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class IOSimulatorTest {
	private String comandi;
	private DiaDia diadia;
	private IO simulatore;
	
	@BeforeEach
	public void SetUp1() {
		comandi = new String("aiuto\nvai nord");
		simulatore = new IOSimulator(comandi);
		diadia = new DiaDia(simulatore);
	}
	
	@Test
	public void test1() {
		diadia.gioca();
	}
	
	@Test
	public void test2() {
		comandi = new String("vai sud\nprendi ascia\nvai est\nguarda\nfine");
		simulatore = new IOSimulator(comandi);
		diadia = new DiaDia(simulatore);
		diadia.gioca();
	}
	
}