package it.uniroma3.diadia.giocatore;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.*;

public class Giocatore {
	private int cfu;
	private Borsa borsa;
	static final private int CFU_INIZIALI = 20;
	
	
	public Giocatore() {
		cfu = CFU_INIZIALI;
		borsa = new Borsa();
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();
		
		s.append("Attualmente hai a disposizione: " +this.cfu + " CFU.\n" +this.borsa.toString());
		return s.toString();
	}
	
}
