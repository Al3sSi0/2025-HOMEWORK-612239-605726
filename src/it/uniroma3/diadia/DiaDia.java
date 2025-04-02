package it.uniroma3.diadia;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;

import java.util.Scanner;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa"};

	private Partita partita;
	private IOConsole stampe;
	public DiaDia(IOConsole stampe) {
		this.stampe = stampe;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		

		stampe.mostraMessaggio(MESSAGGIO_BENVENUTO);	
		do {	
			istruzione = stampe.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		if(comandoDaEseguire.getNome()==null) {
				stampe.mostraMessaggio("Inserisci un comando!");
			return false;
		}
		else{
			if(comandoDaEseguire.getNome().equals("fine")){
				this.fine(); 
				return true;
			}
			else {
				if(comandoDaEseguire.getNome().equals("vai")){
					this.vai(comandoDaEseguire.getParametro());
				}
				else {
					if(comandoDaEseguire.getNome().equals("aiuto")){
						this.aiuto();
					}
					else {
						if(comandoDaEseguire.getNome().equals("prendi")) {
							this.prendi(comandoDaEseguire.getParametro());
						}
						else {
							if(comandoDaEseguire.getNome().equals("posa")) {
								this.posa(comandoDaEseguire.getParametro());
							}
							else{
								stampe.mostraMessaggio("comando sconosciuto!");;
							}
						}
					}
				}
			}
		}
		if (this.partita.vinta()) {
			stampe.mostraMessaggio("Hai vinto!");
			return true;
		} 
		else{
			return false;
		}	
	}


	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			stampe.mostraMessaggio(elencoComandi[i]+" ");
		stampe.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			stampe.mostraMessaggio("Dove vuoi andare ?");			
			Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			stampe.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCfu();
			this.partita.getGiocatore().setCfu(cfu--);
		}
		stampe.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	
	private void prendi(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			stampe.mostraMessaggio("Cosa vuoi prendere?");
			nomeAttrezzo = stampe.leggiRiga();
		}
		if(partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo))) {
			stampe.mostraMessaggio("oggetto preso");
		}
		else {
			stampe.mostraMessaggio("oggetto non preso");
		}
		partita.getLabirinto().getStanzaCorrente().removeAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo));
	}

	
	private void posa(String nomeAttrezzo) {
		if(nomeAttrezzo==null) {
			stampe.mostraMessaggio("Cosa vuoi posare?");
			nomeAttrezzo = stampe.leggiRiga();	}
		if(partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo))) {
			stampe.mostraMessaggio("oggetto posato");
		}
		else {
			stampe.mostraMessaggio("oggetto non posato");
		}
		
	}
	/**
	 * Comando "Fine".
	 */
	private void fine() {
		stampe.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole stampe = new IOConsole();
		DiaDia gioco = new DiaDia(stampe);
		gioco.gioca();
	}
}

	
