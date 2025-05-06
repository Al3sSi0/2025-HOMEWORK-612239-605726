package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;


public class StanzaBloccata extends Stanza{
	private String nomeAttrezzoUtile;
	private String dirBloccata;
	private IO stampe;
	public StanzaBloccata(String nome) {
		super(nome);
		this.stampe = new IOConsole();
		this.nomeAttrezzoUtile = "passepartout";
		this.dirBloccata = "est";
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(super.getAttrezzo(this.nomeAttrezzoUtile) == null && dir.equals(dirBloccata)){
			stampe.mostraMessaggio("Direzione bloccata!");
			return null;				
		}
		else {
			return super.getStanzaAdiacente(dir);
		}
	}
	
	@Override 
	public String getDescrizione() {
		if(super.getAttrezzo(this.nomeAttrezzoUtile) == null){
			stampe.mostraMessaggio(super.getDescrizione());
			return "La stanza ha la direzione est bloccata!";
		}
		else {
			return super.getDescrizione();
		}
	}
}
