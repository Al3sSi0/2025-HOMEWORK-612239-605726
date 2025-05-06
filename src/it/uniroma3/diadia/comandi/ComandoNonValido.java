package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;


public class ComandoNonValido implements Comando{
	private IO stampe;
	public ComandoNonValido() {
		this.stampe = new IOConsole();
	}
	
	@Override
	public void esegui(Partita partita) {
		stampe.mostraMessaggio("Comando inesistente!");
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
		String s = "comando non valido";
		return s;
	}

}