package is.gestioneappelli;

import java.time.LocalDate;

import is.gestioneappelli.control.GestioneAppelli;
import is.gestioneappelli.entity.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestioneAppelli g = new GestioneAppelli();
		//DOCENTI
		Docente d1= new Docente("Docente1");
		Docente d2= new Docente("Docente2");
		Docente d3= new Docente("Docente3");
		Docente d4= new Docente("Docente4");
	
		//STUDENTI
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);

		//CORSI
		Corso c1= g.creaCorso("corso 1", 1, d1);
		Corso c2= g.creaCorso("corso 2", 1, d1);
		Corso c3= g.creaCorso("corso 3", 1, d2);
		Corso c4= g.creaCorso("corso 1", 1, d2);
		Corso c5= g.creaCorso("corso 1", 1, d3);
		Corso c6= g.creaCorso("corso 1", 1, d4);
		
		
		//CREAZIONE APPELLI
		
		
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.SCRITTA);
		Data data2= new Data(LocalDate.of(2019, 1, 14),Sede.LABORATORIO,TipoProva.CALCOLATORE);
		Data data3= new Data(LocalDate.of(2019, 1, 19),Sede.AULA,TipoProva.ORALE);
		Data data4= new Data(LocalDate.of(2019, 2, 1),Sede.AULA,TipoProva.ORALE);
		
		
		Appello a1 = g.creaAppello(c1);
		Appello a2 = g.creaAppello(c2);
		Appello a3 = g.creaAppello(c1);
		a1.addData(data1);
		a1.addData(data2);
		a1.addData(data3);
		a2.addData(data1);
		a2.addData(data3);
		a3.addData(data4);
		//PROVE STAMPA
		System.out.println(g.Stampa(a1, c1));
		//System.out.println(g.Stampa(a2, c2));
		System.out.println(g.Stampa(a3, c1));
		
		//g.prenotazioneAppello(s1, a1, c1);
		//g.visualizzaPrenotati(a1);
		
	}

}
