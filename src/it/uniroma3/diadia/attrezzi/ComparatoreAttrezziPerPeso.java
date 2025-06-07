package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo> {

	public int compare(Attrezzo obj1, Attrezzo obj2) {
		if(obj1.getPeso()-obj2.getPeso() == 0)
			return obj1.getNome().compareTo(obj2.getNome());
		return obj1.getPeso()-obj2.getPeso();
	}


}
