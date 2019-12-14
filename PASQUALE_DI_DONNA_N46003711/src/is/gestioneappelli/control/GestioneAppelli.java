package is.gestioneappelli.control;

import java.util.*;

import is.gestioneappelli.entity.*;

public class GestioneAppelli {
	public ArrayList<Corso> lista_corsi = new ArrayList<>();
	public ArrayList<Appello> lista_appelli = new ArrayList<>();
	public ArrayList<Studente> lista_studenti_prenotati = new ArrayList<>();
	public Corso creaCorso(String nome, int cfu,Docente docente) {
		
		Corso c = new Corso(nome,cfu,docente);
		//corsi.add(c);
		return c;
	}
	public Appello creaAppello(Corso c) {
		Appello a = new Appello();
		if (!lista_corsi.contains(c)) {
		lista_corsi.add(c);
		c.setAppello(a);
		}
		else {
			c.setAppello(a);
		}	
		return a;
	}
	public void visualizzaCorsi(){
		
		System.out.println("Elenco Corsi: ");
		for(Iterator <Corso> i= lista_corsi.iterator();i.hasNext();) 
			System.out.println(i.next());
	}

	
	public void prenotaAppello(Studente s, Appello a, Corso c) {
		for (Corso corso: lista_corsi) {
			for (Appello appello: c.getAppello()) {
				if(appello.equals(a) && corso.equals(c) )
				{
					appello.addStudente(s);
				}
			}
		}
	}
	
	public void prenotazioneAppello(Studente s, Appello a, Corso c) {
		for (Appello appello: c.getAppello()) {

		if (lista_corsi.contains(c)&& appello.equals(a)) {
			a.addStudente(s);
			System.out.println(a);
		}
	}}
	
	public void visualizzaPrenotati(Appello a) {
		if (lista_studenti_prenotati.isEmpty()) {
			System.out.println("Nessun prenotato");
		}
		else {
			for(Iterator <Studente> i= lista_studenti_prenotati.iterator();i.hasNext();) 
			System.out.println(i.next());}
	}
	public String Stampa(Appello _appello,Corso _corso)
{

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
}
