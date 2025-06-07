package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  docente di POO
 * @version base
 */

public interface Comando {

//    private String nome;
//    private String parametro;
//
//    public Comando(String istruzione) {
//		Scanner scannerDiParole = new Scanner(istruzione);
//
//		// prima parola: nome del comando
//		if (scannerDiParole.hasNext())
//			this.nome = scannerDiParole.next(); 
//
//		// seconda parola: eventuale parametro
//		if (scannerDiParole.hasNext())
//			this.parametro = scannerDiParole.next();
//    }
//
//    public String getNome() {
//        return this.nome;
//    }
//
//    public String getParametro() {
//        return this.parametro;
//    }
//
//    public boolean sconosciuto() {
//        return (this.nome == null);
//    }
    
    public void esegui(Partita partita);

	void setParametro(String parametro);

	String getParametro();

	public void setIo(IO io);
	
	public String getNome();
}