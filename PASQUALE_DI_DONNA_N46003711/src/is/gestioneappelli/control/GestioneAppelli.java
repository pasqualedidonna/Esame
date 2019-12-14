package is.gestioneappelli.control;

import java.util.*;

import is.gestioneappelli.entity.*;

public class GestioneAppelli {
	
	public Corso creaCorso(String nome, int cfu,Docente docente) {
		Corso c = new Corso(nome,cfu,docente);
		return c;
	}
	public Appello creaAppello(Corso corso, Data data) {
		ArrayList<Appello> lista_appelli= new ArrayList<>();
		Appello a = new Appello(data);
		lista_appelli.add(a);
		return a;
		
	}
}
