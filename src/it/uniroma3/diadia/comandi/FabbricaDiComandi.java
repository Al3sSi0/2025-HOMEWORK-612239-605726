package it.uniroma3.diadia.comandi;
import it.uniroma3.diadia.ambienti.*;


import it.uniroma3.diadia.attrezzi.*;
import it.uniroma3.diadia.giocatore.*;



import java.util.Scanner;

public interface FabbricaDiComandi{
	public Comando costruisciComando(String istruzione);
}
