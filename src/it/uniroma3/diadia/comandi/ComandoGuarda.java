package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoGuarda implements Comando{
	private IO stampe;
	public ComandoGuarda() {
		this.stampe = new IOConsole();
	}
	
	public void esegui(Partita partita) {
		stampe.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		stampe.mostraMessaggio(partita.getGiocatore().toString());
	}
	
	public void setParametro(String s) {}
	
	@Override 
	public String getParametro() {
		String st = "";
		return st;
	}
	
	@Override 
	public String getNome() {
		String s = "guarda";
		return s;
	}

}