package is.gestioneappelli.control;

import java.util.*;

import is.gestioneappelli.entity.*;

public class GestioneAppelli {
	public ArrayList<Corso> corsi = new ArrayList<>();
	public Corso creaCorso(String nome, int cfu,Docente docente) {
		
		Corso c = new Corso(nome,cfu,docente);
		//corsi.add(c);
		return c;
	}
	public Appello creaAppello(Corso c) {
		Appello a = new Appello();
		if (!corsi.contains(c)) {
		corsi.add(c);
		c.setAppello(a);
		}
		else {
			c.setAppello(a);
		}	
		return a;
	}
public void visualizzaCorsi(){
		
		System.out.println("Elenco Corsi: ");
		for(Iterator <Corso> i= corsi.iterator();i.hasNext();) 
			System.out.println(i.next());
	}
public String Stampa(Appello _appello,Corso _corso)
{
	ArrayList<Appello> appelli = new ArrayList<>();
	StringBuffer buf = new StringBuffer();
	
	for(Corso c : corsi)
	{
		appelli = c.getAppello();
		for(Appello a : appelli)
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
