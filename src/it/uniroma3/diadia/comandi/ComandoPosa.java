package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoPosa implements Comando{
	private IO stampe;
	private String nomeAttrezzo;
	public ComandoPosa(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
		this.stampe = new IOConsole();
	}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			stampe.mostraMessaggio("Cosa vuoi posare?");
			nomeAttrezzo = stampe.leggiRiga();	
		}
		if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo))) {
			stampe.mostraMessaggio("oggetto posato");
		}
		else {
			stampe.mostraMessaggio("oggetto non posato");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}
	
	@Override 
	public String getParametro() {
		return this.nomeAttrezzo;
	}
	
	@Override 
	public String getNome() {
		String s = "posa";
		return s;
	}

}
