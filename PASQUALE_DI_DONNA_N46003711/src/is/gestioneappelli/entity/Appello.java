package is.gestioneappelli.entity;

import java.util.ArrayList;

public class Appello {
		protected ArrayList<Data> date = new ArrayList<>();
		protected boolean chiuso;
		protected ArrayList<Studente> studenti_prenotati = new ArrayList<>();
		
		public Appello() {
			chiuso= false;
			
		}
		public boolean getStato() {
			return chiuso;
		}
		public void addStudente(Studente s) {
			studenti_prenotati.add(s);
		}
		public void addData(Data _d) {
			date.add(_d);
		}
		public void setStato(boolean _stato) {
			chiuso = _stato;	
		}
		public boolean isAperto() {
			return chiuso;
		}
		public ArrayList<Studente> getStudentiPrenotati(){
			return studenti_prenotati;
		}
		public ArrayList<Data> getDate(){
			return date;
		}
		public String toString()
		{
			StringBuffer buf = new StringBuffer();
			
			if(chiuso == true)
			{
				buf.append("\nSTATO APPELLO = CHIUSO\n");
			}
			else
			{
				buf.append("\nSTATO APPELLO = APERTO\n");
			}
			
			for(Data d : date)
			{
				buf.append("\nDATA = "+d.data+"\nSEDE = "+d.sede+"\nPROVA = "+d.tipo_prova+"\n");
			}
				return buf.toString();
			
		}
}
