package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoAiuto implements Comando{
	private IO stampe;
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};
	public ComandoAiuto() {
		this.stampe = new IOConsole();
	}
	
	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			stampe.mostraMessaggio(elencoComandi[i]+" ");
		stampe.mostraMessaggio("");
	}
	
	@Override
	public void setParametro(String a) {}
	
	@Override 
	public String getParametro() {
		String st = "";
		return st;
	}
	
	@Override 
	public String getNome() {
		String s = "aiuto";
		return s;
	}

}
