package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

public class StanzaBuia extends Stanza{
	private String nomeAttrezzoUtile;
	public StanzaBuia(String nome) {
		super(nome);
		this.nomeAttrezzoUtile = "lanterna";
	}
	
	@Override
    public String getDescrizione() {
        if(super.getAttrezzo(this.nomeAttrezzoUtile) == null) {
            return "Qui c'è un buio pesto!";
        }
        else {
            return super.getDescrizione();
        }
    }
}
