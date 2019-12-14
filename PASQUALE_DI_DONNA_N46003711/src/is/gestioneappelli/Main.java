package is.gestioneappelli;

import is.gestioneappelli.control.GestioneAppelli;
import is.gestioneappelli.entity.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestioneAppelli g = new GestioneAppelli();
		Docente d1= new Docente("paok");
		Studente s1=new Studente("Enzo","Iacchetti","N46000000",1234);
		Corso c1= g.creaCorso("corso 1", 9, d1);
		System.out.println(s1);
		System.out.println(c1);
		//System.out.println(c2);
	}

}
