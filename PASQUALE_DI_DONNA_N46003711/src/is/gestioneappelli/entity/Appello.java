package is.gestioneappelli.entity;

import java.util.ArrayList;

public class Appello {
		protected ArrayList<Data> d = new ArrayList<>();
		protected boolean chiuso;
		protected ArrayList<Studente> studenti_prenotati = new ArrayList<>();
		
		public Appello() {
			chiuso= false;
			
		}
		public Appello(Data _d) {
			chiuso = false;
			d.add(_d);

		}
		public boolean getStato() {
			return chiuso;
		}
		public void addStudente(Studente s) {
			studenti_prenotati.add(s);
		}
		public void addData(Data _d) {
			d.add(_d);
		}
		public boolean apriAppello() {
			return (chiuso);	
		}
		public boolean chiudiAppello() {
			return (!chiuso);	
		}
		public ArrayList<Studente> getStudentiPrenotati(){
			return studenti_prenotati;
		}
		public ArrayList<Data> getDate(){
			return d;
		}
		
}
