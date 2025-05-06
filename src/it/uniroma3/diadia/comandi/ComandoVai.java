package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

import it.uniroma3.diadia.ambienti.*;

import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;


public class ComandoVai implements Comando {
	private String direzione;
	private IO stampe;	
	public ComandoVai(String direzione) {
		this.stampe = new IOConsole();
		this.direzione = direzione;
	}
	
	/**
	* esecuzione del comando
	*/
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
		Stanza prossimaStanza = null;
		
		if(direzione==null) {
			stampe.mostraMessaggio("Dove vuoi andare? Devi specificare una direzione.");
			return;
		}
		
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);
		
		if(prossimaStanza==null) {
			return;
		}
		
		partita.getLabirinto().setStanzaCorrente(prossimaStanza);
		stampe.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
	}
	
	@Override
	public void setParametro(String parametro){
		this.direzione = parametro;		
	}
	
	@Override 
	public String getParametro() {
		return this.direzione;
	}
	
	@Override 
	public String getNome() {
		String s = "vai";
		return s;
	}

}