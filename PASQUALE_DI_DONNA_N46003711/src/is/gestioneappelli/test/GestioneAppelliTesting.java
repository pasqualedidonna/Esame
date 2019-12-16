package is.gestioneappelli.test;


import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import is.gestioneappelli.control.GestioneAppelli;
import is.gestioneappelli.entity.*;

public class GestioneAppelliTesting {
	
	GestioneAppelli g;
	Docente d;
	
	@Before 
	public void setUp() {
		g = new GestioneAppelli();
		d = new Docente();
	}
	
	@Test
	public void test1() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Corso c1= g.creaCorso("corso1", 1, d);
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.ORALE);
		Appello a1 = g.creaAppello(c1,data1);
		g.prenotazioneAppello(s1, a1, c1);
		
		assertEquals(1,a1.getNumPartecipanti());
		
	}
	@Test
	public void test2() {
		Corso c1= g.creaCorso("corso1", 1, d);
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.ORALE);
		Appello a1 = g.creaAppello(c1,data1);

		g.visualizzaPrenotati(a1);
		assertEquals(0,a1.getNumPartecipanti());
		
	}
	@Test
	public void test3() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		Corso c2= g.creaCorso("corso2", 1, d);
		
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.ORALE);
		
		Appello a1 = g.creaAppello(c1,data1);
		Appello a2 = g.creaAppello(c2,data1);
		
		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s1, a2, c2);
		
		assertEquals(1,a1.getNumPartecipanti());
		assertEquals(1,a2.getNumPartecipanti());
		
	}
	@Test
	public void test4() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Studente s2=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.ORALE);
		
		Appello a1 = g.creaAppello(c1,data1);

		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s2, a1, c1);
		
		assertEquals(2,a1.getNumPartecipanti());
	}
	@Test
	public void test5() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.ORALE);
		
		Appello a1 = g.creaAppello(c1,data1);
		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s1, a1, c1);
		
		assertEquals(1,a1.getNumPartecipanti());
	}
	@Test
	public void test6() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Studente s2=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		Studente s4=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		Studente s5=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		Studente s3=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data data1= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.SCRITTA);
		Data data2= new Data(LocalDate.of(2019, 1, 1),Sede.AULA,TipoProva.ORALE);
		
		Appello a1 = g.creaAppello(c1,data1);
		Appello a2 = g.creaAppello(c1,data2);
		
		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s2, a1, c1);
		g.prenotazioneAppello(s3, a1, c1);
		g.prenotazioneAppello(s4, a2, c1);
		g.prenotazioneAppello(s5, a2, c1);
		
		assertEquals(3,a1.getNumPartecipanti());
		assertEquals(2,a2.getNumPartecipanti());
	}
	@Test
	public void test7() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Studente s2=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		Studente s3=new Studente("NomeStudente3","CognStudente3","matricola3",2);
		Studente s4=new Studente("NomeStudente4","CognStudente4","matricola4",2);
		
		Data d1= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.SCRITTA);
		Data d2= new Data(LocalDate.of(2019, 11, 9), Sede.AULA, TipoProva.ORALE);
		Data d3= new Data(LocalDate.of(2019, 12, 21), Sede.AULA, TipoProva.SCRITTA);
		Data d4= new Data(LocalDate.of(2019, 11, 10), Sede.AULA, TipoProva.ORALE);
		
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Appello a1= g.creaAppello(c1, d1);
		a1.addData(d2);
		Appello a2= g.creaAppello(c1, d3);
		a2.addData(d4);
		
		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s2, a1, c1);
		g.prenotazioneAppello(s3, a1, c1);
		g.prenotazioneAppello(s4, a1, c1);
		
		g.chiudiAppello(c1, a1);
		
		g.prenotazioneAppello(s1, a2, c1);
		g.prenotazioneAppello(s2, a2, c1);
		g.prenotazioneAppello(s3, a2, c1);
		g.prenotazioneAppello(s4, a2, c1);
		
		assertEquals(4, a1.getNumPartecipanti());
		assertEquals(4, a2.getNumPartecipanti());
	}
	@Test
	public void test8() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Studente s2=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		Studente s3=new Studente("NomeStudente3","CognStudente3","matricola3",3);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		Corso c2= g.creaCorso("corso2", 1, d);
		
		Data d1= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.ORALE);
		Data d2= new Data(LocalDate.of(2019, 11, 9), Sede.AULA, TipoProva.ORALE);
		
		Appello a1= g.creaAppello(c1, d1);
		Appello a2= g.creaAppello(c2, d2);
		
		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s2, a1, c1);
		
		g.prenotazioneAppello(s1, a2, c2);
		g.prenotazioneAppello(s2, a2, c2);
		g.prenotazioneAppello(s3, a2, c2);
		
		assertEquals(2, a1.getNumPartecipanti());
		assertEquals(3, a2.getNumPartecipanti());
		
	}
	@Test
	public void test9() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data d1= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.ORALE);
		
		Appello a1= g.creaAppello(c1, d1);
		
		g.chiudiAppello(c1, a1);
		g.prenotazioneAppello(s1, a1, c1);
		
		assertEquals(0, a1.getNumPartecipanti());
		
	}
	@Test
	public void test10() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Studente s2=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data d1= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.ORALE);
		
		Appello a1= g.creaAppello(c1, d1);
		
		g.prenotazioneAppello(s1, a1, c1);
		g.chiudiAppello(c1, a1);
		g.prenotazioneAppello(s2, a1, c1);
		
		assertEquals(1, a1.getNumPartecipanti());	
	}
	@Test
	public void test11() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data d1= new Data(LocalDate.of(2019, 11, 18), Sede.AULA, TipoProva.ORALE);
		Data d2= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.ORALE);
		
		Appello a1= g.creaAppello(c1, d1);
		Appello a2= g.creaAppello(c1, d2);
		
		g.prenotazioneAppello(s1, a1, c1);
		g.prenotazioneAppello(s1, a2, c1);
		
		assertEquals(1, a1.getNumPartecipanti());
		assertEquals(0, a2.getNumPartecipanti());	
	}
	@Test
	public void test12() {
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		Studente s2=new Studente("NomeStudente2","CognStudente2","matricola2",2);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		Corso c2= g.creaCorso("corso2", 1, d);
		
		Data d1= new Data(LocalDate.of(2019, 11, 18), Sede.AULA, TipoProva.ORALE);
		Data d2= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.ORALE);
		
		Appello a1= g.creaAppello(c1, d1);
		Appello a2= g.creaAppello(c2, d1);
		Appello a3= g.creaAppello(c1, d2);
		Appello a4= g.creaAppello(c2, d2);
		
		g.prenotazioneAppello(s1, a1, c1); //i due studenti tentano di prenotarsi a due 
		g.prenotazioneAppello(s2, a1, c1); //appelli del corso c1 quando sono ancora aperti
		g.prenotazioneAppello(s1, a3, c1);
		g.prenotazioneAppello(s2, a3, c1);
		
		
		
		g.prenotazioneAppello(s1, a2, c2);//i due studenti tentano di prenotarsi a due 
		g.prenotazioneAppello(s2, a2, c2);//appelli del corso c2 quando sono ancora aperti
		g.prenotazioneAppello(s1, a4, c2);
		g.prenotazioneAppello(s2, a4, c2);
		
		assertEquals(2, a1.getNumPartecipanti());
		assertEquals(0, a3.getNumPartecipanti());
		assertEquals(2, a2.getNumPartecipanti());
		assertEquals(0, a4.getNumPartecipanti());
	}
	@Test
	public void test13() {
		//il test mi ha permesso di scovare bug in PrentazioneAppello -> fixato
		Studente s1=new Studente("NomeStudente1","CognStudente1","matricola1",1);
		
		Corso c1= g.creaCorso("corso1", 1, d);
		
		Data d1= new Data(LocalDate.of(2019, 10, 18), Sede.AULA, TipoProva.SCRITTA);
		Data d2= new Data(LocalDate.of(2019, 11, 18), Sede.AULA, TipoProva.SCRITTA);
		Data d3= new Data(LocalDate.of(2019, 12, 18), Sede.AULA, TipoProva.SCRITTA);
		
		Appello a1= g.creaAppello(c1, d1);
		Appello a2= g.creaAppello(c1, d2);
		Appello a3= g.creaAppello(c1, d3);
		
		g.chiudiAppello(c1, a1);
		g.prenotazioneAppello(s1, a2, c1);  
		g.chiudiAppello(c1, a2);
		g.prenotazioneAppello(s1, a3, c1);
	
		assertEquals(0, a1.getNumPartecipanti());
		assertEquals(1, a2.getNumPartecipanti());
		assertEquals(1, a3.getNumPartecipanti());	
	}
}
