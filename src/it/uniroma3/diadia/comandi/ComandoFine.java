package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoFine implements Comando{
	private IO stampe;
	public ComandoFine() {
		this.stampe = new IOConsole();
	}
	
	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
		stampe.mostraMessaggio("Grazie di aver giocato!");
	}
	
	@Override
	public void setParametro(String s) {}
	
	@Override 
	public String getParametro() {
		String st = "";
		return st;
	}
	
	@Override 
	public String getNome() {
		String s = "fine";
		return s;
	}

}
