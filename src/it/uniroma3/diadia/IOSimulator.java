package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;
import it.uniroma3.diadia.giocatore.*;

import java.util.Scanner;


public class IOSimulator implements IO{
	private String comandi;
	private Scanner scannerDiLinee;
	public IOSimulator(String comandi) {
		this.comandi = comandi;
		scannerDiLinee = new Scanner(this.comandi);
	}
	
	public void mostraMessaggio(String comandi) {
			System.out.println(comandi);
	}
	
	public String leggiRiga() {
		String riga = scannerDiLinee.nextLine();
		System.out.println(riga);
	
		return riga;
	}
}
