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
	
		//STUDENTI
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);

		//CORSI
		Corso c1= g.creaCorso("corso 1", 1, d1);
	
		
		//CREAZIONE APPELLI
		
		
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.SCRITTA);
		Data data2= new Data(LocalDate.of(2019, 1, 14),Sede.LABORATORIO,TipoProva.CALCOLATORE);
		Data data3= new Data(LocalDate.of(2019, 1, 19),Sede.AULA,TipoProva.ORALE);

		
		
		Appello a1 = g.creaAppello(c1);
		a1.addData(data1);
		a1.addData(data2);
		a1.addData(data3);
		//PROVE STAMPA
		System.out.println(g.Stampa(a1, c1));
	}

}
