package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class ComandoPrendi implements Comando{
	private String nomeAttrezzo;
	private IO stampe;
	public ComandoPrendi(String nome) {
		this.nomeAttrezzo = nome;
		this.stampe = new IOConsole();
	}
	
	@Override
	public void esegui(Partita partita) {
		if(nomeAttrezzo==null) {
			stampe.mostraMessaggio("Inserisci un attrezzo. Cosa vuoi prendere?");
			nomeAttrezzo = stampe.leggiRiga();		}
		if(partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo))) {
			stampe.mostraMessaggio("oggetto preso");
		}
		else {
			stampe.mostraMessaggio("oggetto non preso");
		}
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo));
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
		String s = "prendi";
		return s;
	}

}
