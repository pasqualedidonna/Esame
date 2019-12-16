package is.gestioneappelli.control;

import java.util.*;

import is.gestioneappelli.entity.*;

public class GestioneAppelli {
	public ArrayList<Corso> lista_corsi = new ArrayList<>();

	
	public Corso creaCorso(String nome, int cfu,Docente docente) {
		Corso c = new Corso(nome,cfu,docente);
		lista_corsi.add(c);
		return c;
	}
	public Appello creaAppello(Corso _c, Data _d) {
		Appello a = new Appello(_d);
		if (lista_corsi.contains(_c) && !_d.equals(null)) {
		_c.setAppello(a);
		}
		return a;
	}
	public void visualizzaCorsi(){
		
		System.out.println("Elenco Corsi: ");
		for(Iterator <Corso> i= lista_corsi.iterator();i.hasNext();) 
			System.out.println(i.next());
	}
	public void chiudiAppello(Corso _c,Appello _a) {
		if (lista_corsi.contains(_c) && _a.isAperto())
			_a.setChiuso(true);
	}
	public void prenotazioneAppello(Studente s, Appello a, Corso c) {
	if(controlloPrenotazione1(s,a,c)){
		System.out.println("Appello chiuso");
	}
	else if(controlloPrenotazione2(s,a,c)){
		if(!c.ricercaStudenti(s)){
			a.addStudente(s);		
			}		
	}
	else{
		System.out.println("Studente già prenotato ad appello non concluso dello stesso esame");
		}
}
	public boolean controlloPrenotazione1(Studente s, Appello a, Corso c) {
	boolean res=false;
	if(lista_corsi.contains(c) && c.ricercaAppello(a) && !a.isAperto()) {
	res= true;
	}
	return res;
}
	public boolean controlloPrenotazione2(Studente s, Appello a, Corso c) {
	boolean res=false;
	if(lista_corsi.contains(c) && c.ricercaAppello(a) && a.isAperto()){
		res=true;
	}
	return res;
}
	public void visualizzaPrenotati(Appello a) {
		ArrayList<Studente> lista_studenti_prenotati = new ArrayList<>(a.getStudentiPrenotati());
	
		System.out.println("Studenti prenotati per l'appello :\n");
		if (lista_studenti_prenotati.isEmpty()) {
			System.out.println("Nessun prenotato");
		}
		else {
			for(Iterator <Studente> i= lista_studenti_prenotati.iterator();i.hasNext();) 	
				System.out.println(i.next());}
	}
	public String Stampa(Appello _appello,Corso _corso){
	ArrayList<Appello> lista_appelli = new ArrayList<>();
	StringBuffer buf = new StringBuffer();
	
	for(Corso c : lista_corsi)
	{
		lista_appelli = c.getAppello();
		for(Appello a : lista_appelli)
		{
			if(a.equals(_appello) && c.equals(_corso))
			{
				buf.append("CORSO:\nNOME = "+c.getNome()+"\nDOCENTE = "+c.getDocente()+"\nCFU = "+c.getCfu()+"\n");
				buf.append(a);
				buf.append("\n______________________________________________________________________________________________________________________________________________________________________________________");
			}
		}
	}
	return buf.toString();
}
	public void stampaAppelliPerCorso(Corso c) {
		if (lista_corsi.contains(c)) {
			System.out.println("Gli appelli per il corso -> " +c.getNome() +"  :\n");
			ArrayList<Appello> lista_appelli_presenti = new ArrayList<>(c.getAppello());
			if(lista_appelli_presenti.isEmpty()) 
				System.out.println("no appelli");
			for(Iterator <Appello> i= lista_appelli_presenti.iterator();i.hasNext();) 
				System.out.println(i.next());
				System.out.println("\n________________________________________________________");
			
			}
			else
				System.out.println("corso inesistente");
		}
	}

